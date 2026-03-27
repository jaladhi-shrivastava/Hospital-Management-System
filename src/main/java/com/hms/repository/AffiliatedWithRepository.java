package com.hms.repository;

import com.hms.entity.AffiliatedWith;
import com.hms.entity.AffiliatedWithId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AffiliatedWithRepository
        extends JpaRepository<AffiliatedWith, AffiliatedWithId> {

    // All departments a physician is affiliated with
    List<AffiliatedWith> findById_Physician(Integer physicianId);

    // All physicians affiliated with a department
    List<AffiliatedWith> findById_Department(Integer departmentId);

    // Only primary affiliations for a physician
    List<AffiliatedWith> findById_PhysicianAndPrimaryAffiliationTrue(Integer physicianId);
}
