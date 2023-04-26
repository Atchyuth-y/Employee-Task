package com.reactive.employee.webflux.service;

import com.reactive.employee.webflux.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.employee.webflux.repo.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
  
  @Autowired
  private EmployeeRepository employeeRepository;

  public Flux<Employee> getAllEmployees(){
    return employeeRepository.findAll();
  }

  public  Mono<Employee> addEmployee(Employee employee){
    return employeeRepository.save(employee);
  }

  public Mono<Employee> updateEmployee(Employee employee, String employeeId){
    return employeeRepository.findById(employeeId)
    .map(s -> {
      s.setEmployeeName(employee.getEmployeeName());
      s.setAddress(employee.getAddress());
      s.setDepartment(employee.getDepartment());
      return s;
    }).flatMap(s -> employeeRepository.save(s));
  }

  /* @Override
  public Flux<Employee> findByDept(String department) {
    Flux<Employee> dept = employeeRepository.findByDept(department);
    return dept;
  } */
}
