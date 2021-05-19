package com.example.FirstWeb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	//We Don't need to use Servlet & Session neither need to return view name like that.
/*	@RequestMapping("home")						
	public String home(HttpServletRequest request) { 
		
		
		String name = request.getParameter("name");
		System.out.println("Home page welcomes you "+ name);
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		return "home";	//Changed home.jsp -> home, loose coupling & used application.properties for configuration
	}
*/
	
	
	//Reason for using Spring MVC
/*	@RequestMapping("home")						
	public ModelAndView home(@RequestParam("name") String name) { 
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.setViewName("home");
		return mv;
	}
*/
	
	//User is sending multiple details about person.
	@RequestMapping("home")						
	public ModelAndView home(Person p) { 
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", p);
		mv.setViewName("home");
		return mv;
	}
}
