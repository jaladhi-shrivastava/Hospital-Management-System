package com.hms.service.base.impl;

import com.hms.entity.Undergoes;
import com.hms.entity.UndergoesId;
import com.hms.repository.UndergoesRepository;
import com.hms.service.base.UndergoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UndergoesServiceImpl implements UndergoesService {

    @Autowired
    private UndergoesRepository undergoesRepository;

    @Override
    public Undergoes saveUndergoes(Undergoes undergoes) {
        return undergoesRepository.save(undergoes);
    }

    @Override
    public List<Undergoes> getAllUndergoes() {
        return undergoesRepository.findAll();
    }

    @Override
    public Undergoes getUndergoesById(UndergoesId id) {
        return undergoesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Undergoes record not found"));
    }

    @Override
    public void deleteUndergoes(UndergoesId id) {
        undergoesRepository.deleteById(id);
    }
}