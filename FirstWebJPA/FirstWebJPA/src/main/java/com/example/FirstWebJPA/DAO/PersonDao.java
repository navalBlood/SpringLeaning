package com.example.FirstWebJPA.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.FirstWebJPA.Model.Person;
import java.util.List;

public interface PersonDao extends JpaRepository<Person, Integer>{
	
	//We can make our own methods
	
	List<Person> findByName(String name);
	
	@Query("from Person where name=?1 order by dept")
	List<Person> findByNameSorted(String name);
	

}
