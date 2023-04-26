package com.reactive.employee.webflux.repo;

import com.reactive.employee.webflux.entity.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.util.Optional;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {

    //public Flux<Employee> findByDept(String department);
}
