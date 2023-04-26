package com.among.employee.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employee_details")
public class Employee {
  @Id
  private String employeeId;

  private String employeeName;
  private String department;
  private String address;


}
