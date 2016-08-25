package com.journaldev.spring;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.journaldev.spring.controller.EmpRestURIConstants;
import com.journaldev.spring.model.Employee;

public class TestSpringRestExample {

	public static final String SERVER_URI = "http://localhost:8088/SpringRestExample";
	
	public static void main(String args[]){
		
		//testGetDummyEmployee();
		//System.out.println("*****");
		testCreateEmployee();
		System.out.println("*****");
		testGetEmployee();
		System.out.println("*****");
		testGetAllEmployee();
	}

	private static void testGetAllEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Employee> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI+EmpRestURIConstants.GET_ALL_EMP, List.class);
		System.out.println(emps.size());
		for(LinkedHashMap map : emps){
			System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",CreatedDate="+map.get("createdDate"));;
		}
	}

	private static void testCreateEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = new Employee();
		emp.setId(2);
		emp.setName("York Chen");		
		Employee response = restTemplate.postForObject(SERVER_URI+EmpRestURIConstants.CREATE_EMP, emp, Employee.class);

		Employee emp2 = new Employee();
		emp2.setId(3);
		emp2.setName("Matt Chen4");
		response = restTemplate.postForObject(SERVER_URI+EmpRestURIConstants.CREATE_EMP, emp2, Employee.class);
		
		Employee emp3 = new Employee();
		emp3.setId(4);
		emp3.setName("Mark Chen4");
		response = restTemplate.postForObject(SERVER_URI+EmpRestURIConstants.CREATE_EMP, emp3, Employee.class);
				
		printEmpData(response);

	}

	private static void testGetEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = restTemplate.getForObject(SERVER_URI+"/rest/emp/1", Employee.class);
		printEmpData(emp);
	}

	private static void testGetDummyEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = restTemplate.getForObject(SERVER_URI+EmpRestURIConstants.DUMMY_EMP, Employee.class);
		printEmpData(emp);
	}
	
	public static void printEmpData(Employee emp){
		if (emp!=null)
		System.out.println("ID="+emp.getId()+",Name="+emp.getName()+",CreatedDate=");
	}
}
