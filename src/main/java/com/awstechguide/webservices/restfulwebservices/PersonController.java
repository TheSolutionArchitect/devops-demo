package com.awstechguide.webservices.restfulwebservices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awstechguide.webservices.restfulwebservices.domain.Person;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class PersonController {

	Person p1 = new Person("1", "Person1", "email1@gmail.com", new Date(), "7623234", true);
	

	
	
	//dynamic filtering used
	@GetMapping("/filter/person")
	public MappingJacksonValue dynamicFiltering() {				
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("personName","status");
		FilterProvider filters = new SimpleFilterProvider().addFilter("PersonModelFilter", filter);		
		MappingJacksonValue mapping = new MappingJacksonValue(p1);
		mapping.setFilters(filters);
		return mapping;
	}
	
	@GetMapping("/filter/person/list")
	public MappingJacksonValue dynamicFilteringList() {	
		List<Person> pList = new ArrayList<Person>();
		pList.add(new Person("1", "Person1", "email1@gmail.com", new Date(), "7623234", true));
		pList.add(new Person("2", "Person2", "email2@gmail.com", new Date(), "5623234", false));
		pList.add(new Person("3", "Person3", "email3@gmail.com", new Date(), "4623234", true));
		pList.add(new Person("4", "Person4", "email4@gmail.com", new Date(), "8623234", false));
				
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("personName","status");
		FilterProvider filters = new SimpleFilterProvider().addFilter("PersonModelFilter", filter);		
		MappingJacksonValue mapping = new MappingJacksonValue(pList);
		mapping.setFilters(filters);
		return mapping;
	}
}
