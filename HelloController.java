package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {

	@GetMapping("/hello")
	public String hello(@RequestParam(name = "name", required = false, defaultValue = "Victor") String name, String greeting
			Model model) {
		model.addAttribute("name", name);
		model.addAttribute("greeting", greeting);

		return "Hello, " + name;
	}

}
