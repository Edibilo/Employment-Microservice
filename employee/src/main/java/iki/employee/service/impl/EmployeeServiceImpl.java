package iki.employee.service.impl;

import iki.employee.dto.ApiResponse;
import iki.employee.dto.DepartmentDto;
import iki.employee.dto.EmployeeDto;
import iki.employee.entity.Employee;
import iki.employee.exception.AlreadyExistException;
import iki.employee.exception.ResourceNotFoundException;
import iki.employee.mapper.EmployeeMapper;
import iki.employee.repository.EmployeeRepository;
import iki.employee.service.APIClient;
import iki.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
  //  private final RestTemplate restTemplate;
  //  private final WebClient webClient;
    private final APIClient apiClient;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, APIClient apiClient) {
        this.employeeRepository = employeeRepository;
        this.apiClient = apiClient;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        if(employeeRepository.existsByEmail(employeeDto.getEmail())){
            throw new AlreadyExistException("Email Already Found !");
        }

        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee employee1=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(employee1);
    }

    @Override
    public ApiResponse findEmployeeById(Long id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee of that Id "+id+" Not Found !"));

      //  ResponseEntity<DepartmentDto> departmentDtoResponse=restTemplate.getForEntity
      //          ("http://localhost:8080/departments/code/"+employee.getDepartmentCode(),DepartmentDto.class);
      //  DepartmentDto departmentDto=departmentDtoResponse.getBody();
/*
        DepartmentDto departmentDto=webClient.get()
                .uri("http://localhost:8080/departments/code/"+employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

 */
        DepartmentDto departmentDto=apiClient.getDepartmentByCode(employee.getDepartmentCode());

        EmployeeDto employeeDto=EmployeeMapper.mapToEmployeeDto(employee);
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setEmployee(employeeDto);
        apiResponse.setDepartment(departmentDto);
        return apiResponse;
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }
}
