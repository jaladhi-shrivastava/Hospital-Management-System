package com.hms.service.base.impl;

import com.hms.entity.AffiliatedWith;
import com.hms.entity.AffiliatedWithId;
import com.hms.exception.ResourceNotFoundException;
import com.hms.repository.AffiliatedWithRepository;
import com.hms.service.base.AffiliatedWithService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AffiliatedWithServiceImpl implements AffiliatedWithService {

    private final AffiliatedWithRepository affiliatedWithRepository;

    @Override
    public List<AffiliatedWith> getAll() {
        return affiliatedWithRepository.findAll();
    }

    @Override
    public Optional<AffiliatedWith> getById(AffiliatedWithId id) {
        return affiliatedWithRepository.findById(id);
    }

    @Override
    public List<AffiliatedWith> getByPhysician(Integer physicianId) {
        return affiliatedWithRepository.findById_Physician(physicianId);
    }

    @Override
    public List<AffiliatedWith> getByDepartment(Integer departmentId) {
        return affiliatedWithRepository.findById_Department(departmentId);
    }

    @Override
    public List<AffiliatedWith> getPrimaryAffiliationsByPhysician(Integer physicianId) {
        return affiliatedWithRepository
                .findById_PhysicianAndPrimaryAffiliationTrue(physicianId);
    }

    @Override
    @Transactional
    public AffiliatedWith save(AffiliatedWith affiliatedWith) {
        return affiliatedWithRepository.save(affiliatedWith);
    }

    @Override
    @Transactional
    public AffiliatedWith updatePrimaryAffiliation(AffiliatedWithId id, Boolean primary) {
        AffiliatedWith existing = affiliatedWithRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "AffiliatedWith record not found"));
        existing.setPrimaryAffiliation(primary);
        return affiliatedWithRepository.save(existing);
    }

    @Override
    @Transactional
    public void delete(AffiliatedWithId id) {
        if (!affiliatedWithRepository.existsById(id)) {
            throw new ResourceNotFoundException("AffiliatedWith record not found");
        }
        affiliatedWithRepository.deleteById(id);
    }
}
