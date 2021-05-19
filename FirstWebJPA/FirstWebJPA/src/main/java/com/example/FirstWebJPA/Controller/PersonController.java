package com.example.FirstWebJPA.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.FirstWebJPA.DAO.PersonDao;
import com.example.FirstWebJPA.Model.Person;

@Controller
public class PersonController {
	
	@Autowired
	PersonDao dao;
	
	@RequestMapping("/")						
	public ModelAndView home() { 		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");	//sets view.
		return mv;
	}
	
	@RequestMapping("/add")						
	public ModelAndView add(Person p) { 		
		ModelAndView mv = new ModelAndView();
		dao.save(p);		//saves in DB.
		System.out.println("saved");
		mv.setViewName("add");
		return mv;
	}
	
	@RequestMapping("/fetch")						
	public ModelAndView fetch(@RequestParam int id) { 		
		ModelAndView mv = new ModelAndView();
		Person person = dao.findById(id).orElse(new Person());	//fetches from DB.
		mv.addObject(person);	//sends to view for it's use.
		System.out.println("fetched");
		System.out.println(dao.findByName("tech"));
		System.out.println(dao.findByNameSorted("tech"));
		mv.setViewName("fetch");
		return mv;
	}
	@RequestMapping("/delete")						
	public ModelAndView delete(@RequestParam int id) { 		
		ModelAndView mv = new ModelAndView();
		long countOld =dao.count();
		mv.addObject(countOld);
		Person person = dao.findById(id).orElse(new Person());
		mv.addObject(person);
		dao.deleteById(id);
		long countNew =dao.count();
		mv.addObject(countNew);	
		System.out.println("deleted");
		mv.setViewName("delete");
		return mv;
	}
	
	//creating a service, sort of API
	@RequestMapping(path="/persons", produces = {"application/xml"})	
	@ResponseBody
	public List<Person> persons() { 				
		return dao.findAll();
	}
	
	@RequestMapping("/person/{id}")	
	@ResponseBody
	public Optional<Person> add(@PathVariable("id") int id) { 				
		return dao.findById(id);
	}
	
	//handling post request, adding record to DB
	@PostMapping("/person")
	@ResponseBody
	public Person addPerson(@RequestBody Person person) { 		
		dao.save(person);
		return person;
	}
	
	@DeleteMapping("/person/{id}")	
	@ResponseBody
	public String deletePerson(@PathVariable("id") int id) { 	
		dao.deleteById(id);
		return "deleted";
	}
	
	@PutMapping("/person")
	@ResponseBody
	public Person saveOrUpdatePerson(@RequestBody Person person) { 		
		dao.save(person);
		return person;
	}
	
	
}
