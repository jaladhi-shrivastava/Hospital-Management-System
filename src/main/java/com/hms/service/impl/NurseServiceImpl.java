package com.hms.service.impl;

import com.hms.entity.Nurse;
import com.hms.repository.NurseRepository;
import com.hms.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseServiceImpl implements NurseService {

    @Autowired
    private NurseRepository nurseRepository;

    @Override
    public Nurse saveNurse(Nurse nurse) {
        return nurseRepository.save(nurse);
    }

    @Override
    public List<Nurse> getAllNurses() {
        return nurseRepository.findAll();
    }

    @Override
    public Nurse getNurseById(Integer id) {
        return nurseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nurse not found with id: " + id));
    }

    @Override
    public Nurse updateNurse(Integer id, Nurse nurse) {
        Nurse existingNurse = nurseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nurse not found with id: " + id));

        existingNurse.setName(nurse.getName());
        existingNurse.setPosition(nurse.getPosition());
        existingNurse.setRegistered(nurse.getRegistered());
        existingNurse.setSsn(nurse.getSsn());

        return nurseRepository.save(existingNurse);
    }

    @Override
    public void deleteNurse(Integer id) {
        nurseRepository.deleteById(id);
    }
}