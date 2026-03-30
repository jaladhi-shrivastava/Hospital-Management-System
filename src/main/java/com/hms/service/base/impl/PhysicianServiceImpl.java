package com.hms.service.base.impl;

import com.hms.entity.Physician;
import com.hms.repository.PhysicianRepository;
import com.hms.service.base.PhysicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhysicianServiceImpl implements PhysicianService {

    @Autowired
    private PhysicianRepository physicianRepository;

    @Override
    public Physician savePhysician(Physician physician) {
        return physicianRepository.save(physician);
    }

    @Override
    public List<Physician> getAllPhysicians() {
        return physicianRepository.findAll();
    }

    @Override
    public Physician getPhysicianById(Integer id) {
        return physicianRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Physician not found with id: " + id));
    }

    @Override
    public Physician updatePhysician(Integer id, Physician physician) {
        Physician existingPhysician = physicianRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Physician not found with id: " + id));

        existingPhysician.setName(physician.getName());
        existingPhysician.setPosition(physician.getPosition());
        existingPhysician.setSsn(physician.getSsn());

        return physicianRepository.save(existingPhysician);
    }

    @Override
    public void deletePhysician(Integer id) {
        Physician existingPhysician = physicianRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Physician not found with id: " + id));

        physicianRepository.delete(existingPhysician);
    }
}