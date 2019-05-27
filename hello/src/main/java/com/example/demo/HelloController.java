package com.example.demo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private String turno() {
		int dayHour = LocalTime.now().getHour();

		if (dayHour >= 12 && dayHour < 18) {
			return "boa tarde!";
		} else if (dayHour >= 18) {
			return "boa noite!";
		} else {
			return "bom dia!";
		}
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);

		return "Hello, " + name + ", " + turno();
	}

	@GetMapping("/time")
	public String hello() {
		
		//nao sei exatamente como pegar a hora do servidor!!
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.US);
		LocalTime time = LocalTime.now();
		String f = formatter.format(time);
		
		return "Hello , its " + f + " here in the server side!";
	}
}
