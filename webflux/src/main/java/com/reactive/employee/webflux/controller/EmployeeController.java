package com.reactive.employee.webflux.controller;

import com.reactive.employee.webflux.entity.Employee;
import com.reactive.employee.webflux.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
  
  @Autowired
  private EmployeeServiceImpl employeeService;

  @PostMapping("/add")
  public Mono<Employee> createEmployee(@RequestBody Employee employee){
    return employeeService.addEmployee(employee);
  }

  @PutMapping("/update/{employeeId}")
  public Mono<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("employeeId")String employeeId){
    return employeeService.updateEmployee(employee, employeeId);
  }

  @GetMapping("/all")
  public Flux<Employee> getAllEmployees(){
    return employeeService.getAllEmployees();
  }

 /* @GetMapping("/getbyDepartment")
  public Flux<Employee> findByDept(String department) {
    Flux<Employee> dept = employeeService.findByDept(department);
    return dept;
  } */

}
