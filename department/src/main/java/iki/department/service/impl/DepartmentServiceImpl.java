package iki.department.service.impl;

import iki.department.dto.DepartmentDto;
import iki.department.entity.Department;
import iki.department.exception.ResourceNotFound;
import iki.department.mapper.DepartmentMapper;
import iki.department.repository.DepartmentRepository;
import iki.department.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
     Department department=DepartmentMapper.mapToDepartment(departmentDto);
     Department department1=departmentRepository.save(department);
     return DepartmentMapper.mapToDepartmentDto(department1);
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department department=departmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Department with ID "+id+" Not Found !"));
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments=departmentRepository.findAll();
        return departments.stream().map(DepartmentMapper::mapToDepartmentDto).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department=departmentRepository.findByDepartmentCode(code).orElseThrow(
                () -> new ResourceNotFound("Department of ID "+code+" Not Found !")
        );
        return DepartmentMapper.mapToDepartmentDto(department);
    }
}
