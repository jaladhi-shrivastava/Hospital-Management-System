package com.hms.repository;

import com.hms.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    // Find all departments whose head is a specific physician
    List<Department> findByHead_EmployeeId(Integer physicianId);

    // Find department by name (case-insensitive)
    List<Department> findByNameContainingIgnoreCase(String name);
}
