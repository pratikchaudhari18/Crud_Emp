package com.demo.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.crud.entity.Employee;

public interface EmployeeRepository  extends  JpaRepository<Employee,Long>
{

}
