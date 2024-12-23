package com.rest.webservice.restful_Webservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("field1") // this will be ignored in response
@JsonFilter("SomeBeanFilter")
public class SomeBean {

	private String field1;
	@JsonIgnore // this will be ignored in response
	private String field2;
	private String field3;
	private String field4;
	private String field5;
	private String field6;

	public SomeBean(String field1, String field2, String field3, String field4, String field5, String field6) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
		this.field6 = field6;
	}

	public String getField1() {
		return field1;
	}

	public String getField2() {
		return field2;
	}

	public String getField3() {
		return field3;
	}

	public String getField4() {
		return field4;
	}

	public String getField5() {
		return field5;
	}

	public String getField6() {
		return field6;
	}

	@Override
	public String toString() {
		return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + ", field4=" + field4
				+ ", field5=" + field5 + ", field6=" + field6 + "]";
	}

}
