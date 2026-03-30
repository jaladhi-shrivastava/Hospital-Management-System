package com.hms.service.base.impl;

import com.hms.entity.Stay;
import com.hms.repository.StayRepository;
import com.hms.service.base.StayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StayServiceImpl implements StayService {

    @Autowired
    private StayRepository stayRepository;

    @Override
    public Stay saveStay(Stay stay) {
        return stayRepository.save(stay);
    }

    @Override
    public List<Stay> getAllStays() {
        return stayRepository.findAll();
    }

    @Override
    public Stay getStayById(Integer id) {
        return stayRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stay not found with ID: " + id));
    }

    @Override
    public Stay updateStay(Integer id, Stay stay) {
        Stay existingStay = stayRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stay not found with ID: " + id));

        existingStay.setStayStart(stay.getStayStart());
        existingStay.setStayEnd(stay.getStayEnd());
        existingStay.setPatient(stay.getPatient());
        existingStay.setRoom(stay.getRoom());

        return stayRepository.save(existingStay);
    }

    @Override
    public void deleteStay(Integer id) {
        Stay existingStay = stayRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stay not found with ID: " + id));

        stayRepository.delete(existingStay);
    }
}