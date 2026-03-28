package com.hms.service;

import com.hms.entity.AffiliatedWith;
import com.hms.entity.AffiliatedWithId;
import java.util.List;
import java.util.Optional;

public interface AffiliatedWithService {

    List<AffiliatedWith> getAll();

    Optional<AffiliatedWith> getById(AffiliatedWithId id);

    List<AffiliatedWith> getByPhysician(Integer physicianId);

    List<AffiliatedWith> getByDepartment(Integer departmentId);

    List<AffiliatedWith> getPrimaryAffiliationsByPhysician(Integer physicianId);

    AffiliatedWith save(AffiliatedWith affiliatedWith);

    AffiliatedWith updatePrimaryAffiliation(AffiliatedWithId id, Boolean primary);

    void delete(AffiliatedWithId id);
}
