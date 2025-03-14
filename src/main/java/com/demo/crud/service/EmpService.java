package com.demo.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.crud.entity.Employee;
import com.demo.crud.repository.EmployeeRepository;




@Service 
public class EmpService {
	@Autowired 
	
	private EmployeeRepository employeeRepository;
	
	public List<Employee> findAll() 
	{
		return employeeRepository.findAll();
	}
	
	public Employee save(Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

}
