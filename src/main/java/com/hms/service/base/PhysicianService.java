package com.hms.service.base;

import com.hms.entity.Physician;
import java.util.List;

public interface PhysicianService {
    Physician savePhysician(Physician physician);
    List<Physician> getAllPhysicians();
    Physician getPhysicianById(Integer id);
    Physician updatePhysician(Integer id, Physician physician);
    void deletePhysician(Integer id);
}