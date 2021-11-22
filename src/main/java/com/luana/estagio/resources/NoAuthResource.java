package com.luana.estagio.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/noAuth")
public class NoAuthResource {

	@GetMapping("/Hi")
	public String sayHi() {
		return "Hi";
	}
	
}
