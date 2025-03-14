package com.demo.crud.controller;

import com.demo.crud.entity.Employee;
import com.demo.crud.service.EmpService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api") 
public class EmployeeController {
	
	
	@Autowired	
	private EmpService empService;
	/*
	 * @GetMapping("/get") public String index() { return "index"; }
	 */
	 
	// get my all employees
	@GetMapping("/allemp")
	private List<Employee> getAllEmployees() {
		return empService.findAll();
	}

	// post employees
	@PostMapping("/empsave")
	public Employee createEmployee(@RequestBody Employee employee) {
		return empService.save(employee);
	}

	// get a employee by id
	@GetMapping("/emp/{id}")
	public Employee getItemById(@PathVariable Long id) {
		return empService.findById(id);
	}

	// update my employee
	@PutMapping("/empupdate/{id}")
	public Employee updateItem(@PathVariable Long id, @RequestBody Employee employeeDetails) {
		Employee employee = empService.findById(id);
		employee.setName(employeeDetails.getName());
		employee.setSalary(employeeDetails.getSalary());
		employee.setAddress(employeeDetails.getAddress());
		return empService.save(employee);
	}
	// delete my emp
	@DeleteMapping("/empdelete/{id}")
	public void deleteItem(@PathVariable Long id) {
		empService.deleteById(id);
	}
}
