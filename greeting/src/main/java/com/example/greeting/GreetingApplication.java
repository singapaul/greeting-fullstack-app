package com.example.greeting;

import org.apache.logging.log4j.util.Strings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Random;

import java.util.List;

//We will remove line below later when we hook up to database
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication

//lets us talk to API from react app
@CrossOrigin
public class GreetingApplication {
	public static void main(String[] args) {
		SpringApplication.run(GreetingApplication.class, args);


		Greeting dje= new Greeting(1,"d", "d", "d");
	}
}


