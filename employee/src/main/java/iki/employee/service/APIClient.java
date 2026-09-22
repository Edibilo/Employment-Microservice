package iki.employee.service;

import iki.employee.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {

    //get department Rest Api
    @GetMapping("departments/code/{department-code}")
    DepartmentDto getDepartmentByCode(@PathVariable("department-code") String code);
}
