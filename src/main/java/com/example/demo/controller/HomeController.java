package com.example.demo.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.vo.User;

@RestController
@RequestMapping("api/v1")
public class HomeController {
	
	@Autowired
    RestTemplate restTemplate;
    
	@GetMapping("/call")
	public User callAPI() {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <User> entity = new HttpEntity<User>(headers);
	      return restTemplate.exchange
	    		  ("https://jsonplaceholder.typicode.com/todos/1", HttpMethod.GET, entity, User.class).getBody();
	    	   }
	

}
