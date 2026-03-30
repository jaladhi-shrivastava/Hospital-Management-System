package com.hms.service.module.admin;

import com.hms.entity.AffiliatedWith;
import com.hms.entity.Department;
import com.hms.entity.Undergoes;
import com.hms.repository.AffiliatedWithRepository;
import com.hms.repository.DepartmentRepository;
import com.hms.repository.PatientRepository;
import com.hms.repository.StayRepository;
import com.hms.repository.UndergoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AdminModuleServiceImpl implements AdminModuleService {

    @Autowired
    private UndergoesRepository undergoesRepository;

    @Autowired
    private AffiliatedWithRepository affiliatedWithRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private StayRepository stayRepository;

    // Uses JOIN FETCH query — no lazy loading issues
    @Override
    @Transactional(readOnly = true)
    public Double getTotalRevenue() {
        List<Undergoes> allUndergoes = undergoesRepository.findAllWithDetails();
        return allUndergoes.stream()
                .filter(u -> u.getProcedures() != null && u.getProcedures().getCost() != null)
                .mapToDouble(u -> u.getProcedures().getCost())
                .sum();
    }

    // Uses JOIN FETCH query — procedures + physician fully loaded
    @Override
    @Transactional(readOnly = true)
    public List<Undergoes> getProceduresByPatient(Integer patientSsn) {
        return undergoesRepository.findByPatientSsn(patientSsn);
    }

    // Groups AffiliatedWith records by department name and counts physicians
    @Override
    @Transactional(readOnly = true)
    public Map<String, Long> getDoctorCountPerDepartment() {
        List<AffiliatedWith> all = affiliatedWithRepository.findAll();
        List<Department> departments = departmentRepository.findAll();

        Map<Integer, String> deptNames = departments.stream()
                .collect(Collectors.toMap(
                        d -> d.getDepartmentId(),
                        d -> d.getName()
                ));

        Map<String, Long> result = new LinkedHashMap<>();
        all.stream()
                .collect(Collectors.groupingBy(
                        a -> a.getId().getDepartment(),
                        Collectors.counting()
                ))
                .forEach((deptId, count) -> {
                    String deptName = deptNames.getOrDefault(deptId, "Dept-" + deptId);
                    result.put(deptName, count);
                });

        return result;
    }

    // Returns a snapshot map with key hospital-wide counts
    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> getHospitalStatus() {
        Map<String, Object> status = new LinkedHashMap<>();
        status.put("totalPatients",    patientRepository.count());
        status.put("activeAdmissions", stayRepository.findActiveStays().size());
        status.put("occupiedRooms",    stayRepository.findOccupiedRoomStays().size());
        status.put("totalDepartments", departmentRepository.count());
        return status;
    }
}