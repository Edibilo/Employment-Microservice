package iki.employee.service;

import iki.employee.dto.ApiResponse;
import iki.employee.dto.DepartmentDto;
import iki.employee.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    ApiResponse findEmployeeById(Long id);
    List<EmployeeDto> getAllEmployee();
}
