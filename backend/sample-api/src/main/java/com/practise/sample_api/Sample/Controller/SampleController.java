package com.practise.sample_api.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@GetMapping("hello")
	public SampleResponse hello() {
		return new SampleResponse(1, "Hello World!");
	}

	// 参考: https://spring.pleiades.io/guides/gs/rest-service
}
