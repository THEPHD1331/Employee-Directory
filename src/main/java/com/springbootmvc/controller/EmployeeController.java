package com.springbootmvc.controller;

import com.springbootmvc.entity.Employee;
import com.springbootmvc.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> theEmployees= employeeService.findAll();
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model){
		Employee employee= new Employee();
		model.addAttribute("employee", employee);
		return "employees/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){
		Employee theEmp= employeeService.findById(id);
		model.addAttribute("employee", theEmp);
		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee){
		employeeService.save(employee);
		return "redirect:/employees/list";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int id){
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}
}