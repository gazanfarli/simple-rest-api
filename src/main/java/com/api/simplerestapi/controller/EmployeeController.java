package com.api.simplerestapi.controller;

import com.api.simplerestapi.dto.EmployeeDTO;
import com.api.simplerestapi.model.Employee;
import com.api.simplerestapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees () {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById (@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<EmployeeDTO> saveEmployee (@Validated @RequestBody Employee employee) {
        return new ResponseEntity<EmployeeDTO>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
    @PatchMapping("{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee (@PathVariable Long id, @RequestBody Employee employee) {
        return new ResponseEntity<EmployeeDTO>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee (@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(
                String.format("Employee with Id %s successfully deleted", id),
                HttpStatus.OK
        );
    }
}
