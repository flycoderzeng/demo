package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class Application {

	private Logger logger = LoggerFactory.getLogger(Application.class);

	@RequestMapping(value = "/index")
	public String index(Model model) {
		logger.info("welcome to index!");
		return "index";
	}

	@RequestMapping(value = "/login")
	public String login(Model model) {
		return "login";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
