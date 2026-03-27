package com.hms.service;

import com.hms.entity.Department;
import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    List<Department> getAllDepartments();

    Optional<Department> getDepartmentById(Integer departmentId);

    List<Department> getDepartmentsByHead(Integer physicianId);

    List<Department> searchDepartmentsByName(String name);

    Department saveDepartment(Department department);

    Department updateDepartment(Integer departmentId, Department department);

    void deleteDepartment(Integer departmentId);
}