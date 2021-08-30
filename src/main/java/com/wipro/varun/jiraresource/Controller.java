package com.wipro.varun.jiraresource;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class Controller {

	@RequestMapping("/welcome")
	public String welcome() {
		return "hello";
	}


}