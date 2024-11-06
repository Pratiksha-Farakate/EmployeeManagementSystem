package com.tka.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tka.emp.entity.Employee;
import com.tka.emp.service.EmpolyeeService;

@RestController
@CrossOrigin(origins=("http://localhost:4200"))
public class EmployeeController {
	
	@Autowired
	EmpolyeeService empolyeeService;
	
	@PostMapping("/add-employee")
	@CrossOrigin(methods = RequestMethod.POST)
	public String addEmployee(@RequestBody Employee employee) {
		String msg=empolyeeService.addEmployee(employee);		
		
		System.out.println(employee);
		return msg;
		
	}
	
	@PutMapping("/update-employee/{empid}")
	@CrossOrigin(methods = RequestMethod.PUT)
	public String updateemp(@PathVariable int empid, @RequestBody Employee emp) {
		String msg=empolyeeService.updateemp(empid, emp);
		return msg;
		
	}
	@DeleteMapping("/delete-employee/{empid}")
	@CrossOrigin(methods=RequestMethod.DELETE)
	public String deleteEmp(@PathVariable int empid) {
		String msg=empolyeeService.deleteEmp(empid);
		return msg;
		
		
	}
	
	@GetMapping("/getall-employee")
	public List<Employee> getallEmp(){
		List<Employee> list1=empolyeeService.getallEmp();
		return list1;
	}
	
	@GetMapping("/getemployeebyid/{empid}")
	public Employee getempbtid(@PathVariable int empid) {
		Employee employee=empolyeeService.getEmpbyid(empid);
		return employee;
	}
}