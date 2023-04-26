package com.among.employee.Services;

import com.among.employee.Model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee addEmployee(Employee employee);
    public String updateEmployee(Employee employee, String employeeId);
    public List<Employee> allEmployees();
    public List<Employee> employeesByDept(String department);
}
