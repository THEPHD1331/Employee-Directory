package com.springbootmvc.dao;

import com.springbootmvc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findAllByOrderByLastNameAsc(); // Custom method to sort by last name
	
}
