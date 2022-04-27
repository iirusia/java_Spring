package com.example.start.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class restApiController {

		@GetMapping("/get/{number}")
		public String get(@PathVariable String number,@RequestParam String name) {
			return "Hello world "+number+name;
		}
		
		@PostMapping("/post")	//ObjectMapper
		public User post(@RequestBody User user) {
		
					//객체를 리턴시키고 ObjectMapper가 그 객체를 JSON 형태로 바꿔서 보내주고 올때는 반대로
			return user;
		}
}
	