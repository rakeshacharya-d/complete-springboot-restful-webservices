package com.rakesh.rest.webservices.restful_webservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	
	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		someBean someBean = new someBean("value1", "value2", "value3");
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2"));
		mapping.setFilters(filters);
		
		
		return mapping;
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue filteringList() {
		List<someBean> list = Arrays.asList(new someBean("value1", "value2", "value3"),new someBean("value4", "value5","value6"));
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3"));
		mapping.setFilters(filters);
		return mapping;
	}

}
