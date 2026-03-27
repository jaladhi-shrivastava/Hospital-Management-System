package com.hms.service;

import com.hms.entity.Procedures;
import java.util.List;

public interface ProceduresService {
    Procedures saveProcedure(Procedures procedures);
    List<Procedures> getAllProcedures();
    Procedures getProcedureById(Integer id);
    Procedures updateProcedure(Integer id, Procedures procedures);
    void deleteProcedure(Integer id);
}