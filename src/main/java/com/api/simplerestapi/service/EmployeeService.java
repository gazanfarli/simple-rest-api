package com.api.simplerestapi.service;

import com.api.simplerestapi.dto.EmployeeDTO;
import com.api.simplerestapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long id);
    EmployeeDTO saveEmployee(Employee employee);
    EmployeeDTO updateEmployee(Employee employee, Long id);
    void deleteEmployee(Long id);
}
