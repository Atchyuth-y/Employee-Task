package com.among.employee.Services;


import com.among.employee.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.among.employee.Repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl {
  
  @Autowired
  private EmployeeRepository employeeRepository;

  public Employee addEmployee(Employee employee){
    employeeRepository.save(employee);
    return employee;
  }

  public String updateEmployee(Employee employee, String employeeId){
    Optional<Employee> optionalStudent = employeeRepository.findById(employeeId);
    if(optionalStudent.isPresent()){
      Employee savEmployee = optionalStudent.get();
      savEmployee.setEmployeeName(employee.getEmployeeName());
      savEmployee.setDepartment(employee.getDepartment());
      savEmployee.setAddress(employee.getAddress());
      employeeRepository.save(savEmployee);
      return "Employee details updated : " + savEmployee;
    }
    else{
      return "No employee with details " + employee + " was found!";
    }
  }

  public List<Employee> allEmployees(){
    List<Employee> allEmployees = employeeRepository.findAll();
    return allEmployees;
  }

  public List<Employee> employeesByDept(String department){
    List<Employee> employees = employeeRepository.findAll();
    return employees.stream().filter((employee)-> employee.getDepartment().equals(department)).collect(Collectors.toList());
  }
}
