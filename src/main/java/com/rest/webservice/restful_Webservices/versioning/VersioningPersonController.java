package com.rest.webservice.restful_Webservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	/*
	 * URI Versioniong
	 */
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("BOB", "CharlieV2"));
	}

	
	/*
	 * Request Params Versioning by using queryParamter
	 */
	@GetMapping(path="/person",params = "version=1")
	public PersonV1 getFirstVersionOfPersonRequestParams() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path="/person",params = "version=2")
	public PersonV2 getSecondVersionOfPersonRequestParams() {
		return new PersonV2(new Name("BOB", "CharlieV2"));
	}
	
	/*
	 * Request Hearders Versioning Customs Headers
	 */
	@GetMapping(path="/person/header",headers ="X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonRequestHeaders() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path="/person/header",headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonRequestHeaders() {
		return new PersonV2(new Name("BOB", "CharlieV2"));
	}
	/*
	 * Media Type Versioning
	 */
	@GetMapping(path="/person/accept",produces ="application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonMediaTypeVersioningV1_AcceptHeader() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path="/person/accept",produces = "application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionOfPersonMediaTypeVersioningV2_AcceptHeader() {
		return new PersonV2(new Name("BOB", "CharlieV2"));
	}


}
