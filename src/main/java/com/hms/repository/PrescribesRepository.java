package com.hms.repository;

import com.hms.entity.Prescribes;
import com.hms.entity.PrescribesId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescribesRepository extends JpaRepository<Prescribes, PrescribesId> {

    List<Prescribes> findById_Patient(Integer patient);

    List<Prescribes> findById_Physician(Integer physician);
}