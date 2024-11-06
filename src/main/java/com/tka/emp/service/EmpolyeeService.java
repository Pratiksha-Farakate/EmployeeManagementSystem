package com.tka.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.emp.dao.EmployeeDao;
import com.tka.emp.entity.Employee;

@Service
public class EmpolyeeService {
	@Autowired
	EmployeeDao employeeDao;
	
	public String addEmployee(Employee employee) {
		String msg=employeeDao.addEmployee(employee);
		System.out.println(employee);
		return msg;
		
	}
	
	public String updateemp(int empid, Employee emp) {
		String msg=employeeDao.updateemp(empid, emp);
		return msg;
		
	}
	
	public String deleteEmp(int empid) {
		String msg=employeeDao.deleteEmp(empid);
		return msg;
	}
	
	public List<Employee> getallEmp(){
		List list1=employeeDao.getallEmp();
			
		return list1;
		
	}
	
	public Employee getEmpbyid(int empid) {
		Employee employee=employeeDao.getEmpbyid(empid);
		return employee;
		
	}
}
