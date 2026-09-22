package iki.department.mapper;

import iki.department.dto.DepartmentDto;
import iki.department.entity.Department;

public class DepartmentMapper {

    public static Department mapToDepartment(DepartmentDto departmentDto){
        Department department=new Department();
        department.setId(departmentDto.getId());
        department.setDepartmentCode(departmentDto.getDepartmentCode());
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        return department;
    }

    public static DepartmentDto mapToDepartmentDto(Department department){
        DepartmentDto departmentDto=new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setDepartmentCode(department.getDepartmentCode());
        departmentDto.setDepartmentName(department.getDepartmentName());
        departmentDto.setDepartmentDescription(department.getDepartmentDescription());
        return departmentDto;
    }
}
