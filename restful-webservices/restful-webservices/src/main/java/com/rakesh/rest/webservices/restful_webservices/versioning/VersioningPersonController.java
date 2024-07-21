package com.rakesh.rest.webservices.restful_webservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	@GetMapping(path="/person",params="version=1")
	public PersonV1 getFirstVersionOfPersonParam() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path="/person/accept",produces="application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonHeader() {
		return new PersonV1("Bob Charlie");
	}

}
