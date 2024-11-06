package com.tka.emp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.emp.entity.Employee;



@Repository
public class EmployeeDao {
	@Autowired
	SessionFactory sf;
	public String addEmployee(Employee employee) {
		String msg="";
		try {
			
			Session session=sf.openSession();
			session.save(employee);
			session.beginTransaction().commit();
			return "added....";
			
			
		} catch (Exception e) {
			msg="already exist employee";// TODO: handle exception
		}
		return msg;
		
		
		
	}
	
	public String updateemp(int empid,Employee emp) {
		String msg="";
		try {
			
			Session session =sf.openSession();
			Employee employee=session.get(Employee.class,empid);
			if(employee!=null) {
			session.evict(employee);
			session.update(emp);
			session.beginTransaction().commit();
			msg= "update employee successfully";
			}else {
				msg= "employee not exist to update";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			msg="something went wrong";
			// TODO: handle exception
		}
		return msg;
		
	}
	
	public String deleteEmp(int empid) {
		String msg="";
		try {
			Session session=sf.openSession();
			Employee employee=session.get(Employee.class, empid);
			if(employee!=null) {
			session.delete(employee);
			session.beginTransaction().commit();
			msg="Employee deleted successfully";
			}else {
				msg="employee is not exist to delete";
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg="somthing went wrong";
			// TODO: handle exception
		}
		return msg;
		
	}
	
	public List<Employee> getallEmp(){
		List<Employee> list=new ArrayList<>();
		
			Session session=sf.openSession();
			String hql="from Employee";
			Query query=session.createQuery(hql);
			List<Employee>list1=query.list();
			return list1;
			
		
	}
	public Employee getEmpbyid(int empid) {
		Session session=sf.openSession();
		Employee employee=session.get(Employee.class, empid);
		session.beginTransaction().commit();
		return employee;
	}
	
	

}
