package com.api.simplerestapi.service.impl;

import com.api.simplerestapi.dto.EmployeeDTO;
import com.api.simplerestapi.exception.ResourceNotFoundException;
import com.api.simplerestapi.mapper.EmployeeDTOMapper;
import com.api.simplerestapi.model.Employee;
import com.api.simplerestapi.repository.EmployeeRepository;
import com.api.simplerestapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeDTOMapper employeeDTOMapper;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(employeeDTOMapper)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public EmployeeDTO saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employeeDTOMapper.apply(employee);
    }

    @Override
    public EmployeeDTO updateEmployee(Employee employee, Long id) {
        employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

        employeeRepository.save(employee);
        return employeeDTOMapper.apply(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        employeeRepository.deleteById(id);
    }
}
