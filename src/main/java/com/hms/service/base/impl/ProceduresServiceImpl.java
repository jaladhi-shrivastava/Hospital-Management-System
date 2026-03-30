package com.hms.service.base.impl;

import com.hms.entity.Procedures;
import com.hms.repository.ProceduresRepository;
import com.hms.service.base.ProceduresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProceduresServiceImpl implements ProceduresService {

    @Autowired
    private ProceduresRepository proceduresRepository;

    @Override
    public Procedures saveProcedure(Procedures procedures) {
        return proceduresRepository.save(procedures);
    }

    @Override
    public List<Procedures> getAllProcedures() {
        return proceduresRepository.findAll();
    }

    @Override
    public Procedures getProcedureById(Integer id) {
        return proceduresRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Procedure not found with id: " + id));
    }

    @Override
    public Procedures updateProcedure(Integer id, Procedures procedures) {
        Procedures existing = proceduresRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Procedure not found with id: " + id));

        existing.setName(procedures.getName());
        existing.setCost(procedures.getCost());

        return proceduresRepository.save(existing);
    }

    @Override
    public void deleteProcedure(Integer id) {
        proceduresRepository.deleteById(id);
    }
}