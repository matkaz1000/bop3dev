package com.practise.sample_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@GetMapping("hello")
	public String hello() {
		return "Hello, World!";
	}
}
