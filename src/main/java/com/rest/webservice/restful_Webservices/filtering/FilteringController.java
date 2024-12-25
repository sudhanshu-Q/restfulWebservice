package com.rest.webservice.restful_Webservices.filtering;

import java.util.ArrayList;
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
	public SomeBean filtering() {
		return new SomeBean("value1", "value2", "value3", "value4", "value5", "value6");
	}

	@GetMapping("/filtering-list")
	public List<SomeBean> filteringList() {
		return Arrays.asList(new SomeBean("value1", "value2", "value3", "value4", "value5", "value6"),
				new SomeBean("Value11", "Value12", "Value13", "value14", "value15", "value16"));
	}

	// using mapping Jackson value
	@GetMapping("/filtering-jackson")
	public MappingJacksonValue filteringJackson() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3", "value4", "value5", "value6");

		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field5", "field6");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
	
	// using mapping Jackson value for list
	@GetMapping("/filtering-jackson-list")
	public MappingJacksonValue filteringListjackson() {
		List<SomeBean> list= Arrays.asList(new SomeBean("value1", "value2", "value3", "value4", "value5", "value6"),
				new SomeBean("Value11", "Value12", "Value13", "value14", "value15", "value16"));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field4", "field6");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
}
