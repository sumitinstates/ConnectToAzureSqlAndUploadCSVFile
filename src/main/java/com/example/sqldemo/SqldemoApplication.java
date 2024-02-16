package com.example.sqldemo;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SqldemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqldemoApplication.class, args);
	}
	
	@Autowired
	UserRepository repository;
	
	/*@Bean
    ApplicationListener<ApplicationReadyEvent> basicsApplicationListener(TodoRepository repository) {
        return event->repository
            .saveAll(Stream.of("A", "B", "C").map(name->new Todo("configuration", "congratulations, you have set up correctly!", true)).collect(Collectors.toList()))
            .forEach(System.out::println);
    }*/
	
	/*@Bean
    ApplicationListener<ApplicationReadyEvent> basicsApplicationListener2() {
        return event->repository
            .saveAll(Stream.of("A", "B", "C").map(name->new User("arpita vats", "30")).collect(Collectors.toList()))
            .forEach(System.out::println);
    }*/


}
