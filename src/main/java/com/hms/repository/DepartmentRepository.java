package com.hms.repository;

import com.hms.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    List<Department> findByHead_EmployeeId(Integer physicianId);

    List<Department> findByNameContainingIgnoreCase(String name);
}
