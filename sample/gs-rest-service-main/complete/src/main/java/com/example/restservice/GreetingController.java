package com.example.restservice;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

 import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/greeting2")
	public String greeting2(@RequestParam(value = "name", defaultValue = "World") String name) {
//		return new Greeting(counter.incrementAndGet(), String.format(template, name));



		// request url
		String url = "https://reqres.in/api/users";

// create an instance of RestTemplate
		RestTemplate restTemplate = new RestTemplate();

// request body parameters
		Map<String, String> map = new HashMap<>();
		map.put("name", "John Doe");
		map.put("job", "Java Developer");

// send POST request
		ResponseEntity<Void> response = restTemplate.postForEntity(url, map, Void.class);

// check response
		if (response.getStatusCode() == HttpStatus.OK) {
			System.out.println("Request Successful");
		} else {
			System.out.println("Request Failed");
		}

return response.getStatusCode().toString();
	}



	@RequestMapping(value="/greeting3", method = RequestMethod.POST)
	public String greeting3(@RequestParam(value = "name", defaultValue = "World") String name) {
//		return new Greeting(counter.incrementAndGet(), String.format(template, name));



		// request url
		String url = "https://reqres.in/api/users";

// create an instance of RestTemplate
		RestTemplate restTemplate = new RestTemplate();

// request body parameters
		Map<String, String> map = new HashMap<>();
		map.put("name", "John Doe");
		map.put("job", "Java Developer");

// send POST request
		ResponseEntity<Void> response = restTemplate.postForEntity(url, map, Void.class);

// check response
		if (response.getStatusCode() == HttpStatus.OK) {
			System.out.println("Request Successful");
		} else {
			System.out.println("Request Failed");
		}

		return response.getStatusCode().toString();
	}

}
