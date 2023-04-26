package com.among.employee.Controller;

import com.among.employee.Model.Employee;
import com.among.employee.Services.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
  
  @Autowired
  private EmployeeServiceImpl studentService;

  @PostMapping("/addEmployee")
  public String addEmployee(@RequestBody Employee employee){
    studentService.addEmployee(employee);
    return "Employee has been added successfully!";
  }

  @GetMapping("/all")
  public List<Employee> getAllEmployees(){
    return studentService.allEmployees();
  }

  @PutMapping("/update/{employeeId}")
  public String updateEmployee(@RequestBody Employee employee, @PathVariable("employeeId") String employeeId){
    return studentService.updateEmployee(employee, employeeId);
  }

  @GetMapping("/getBydepartment/{department}")
  public List<Employee> getByDept(@PathVariable("department") String department){
    return studentService.employeesByDept(department);
  }
}
