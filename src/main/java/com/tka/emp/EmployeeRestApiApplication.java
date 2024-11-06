package com.tka.emp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tka.emp.dao.EmployeeDao;

@SpringBootApplication
public class EmployeeRestApiApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(EmployeeRestApiApplication.class, args);
		
		
		
	}

}
