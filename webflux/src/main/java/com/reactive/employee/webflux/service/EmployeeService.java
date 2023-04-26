package com.reactive.employee.webflux.service;

import com.reactive.employee.webflux.entity.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface EmployeeService {
    Flux<Employee> getAllEmployees();
    Mono<Employee> addEmployee(Employee employee);
    Mono<Employee> updateEmployee(Employee employee, String employeeId);

    //public Flux<Employee> findByDept(String department);
}
