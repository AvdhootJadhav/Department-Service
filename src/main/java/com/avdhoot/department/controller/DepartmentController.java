package com.avdhoot.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avdhoot.department.entity.Department;
import com.avdhoot.department.repository.DepartmentRepository;
import com.avdhoot.department.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired private DepartmentRepository departmentrepo;
	
	@PostMapping("/save")
	public Department saveDepartment (@RequestBody Department department) {
		System.out.println("################"+department);
		return departmentrepo.save(department);
	
		//return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/{id}")
	public Department findDepartmentById(@PathVariable("id") Long departmentId) {
		return departmentService.findDepartmentById(departmentId);
	}
}
