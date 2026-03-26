package com.hms.service;

import com.hms.entity.Nurse;
import java.util.List;

public interface NurseService {
    Nurse saveNurse(Nurse nurse);
    List<Nurse> getAllNurses();
    Nurse getNurseById(Integer id);
    Nurse updateNurse(Integer id, Nurse nurse);
    void deleteNurse(Integer id);
}