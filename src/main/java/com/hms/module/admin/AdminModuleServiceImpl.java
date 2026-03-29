package com.hms.module.admin;

import com.hms.entity.AffiliatedWith;
import com.hms.entity.Department;
import com.hms.entity.Undergoes;
import com.hms.repository.AffiliatedWithRepository;
import com.hms.repository.DepartmentRepository;
import com.hms.repository.UndergoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Double getTotalRevenue() {
        List<Undergoes> allUndergoes = undergoesRepository.findAll();
        return allUndergoes.stream()
                .filter(u -> u.getProcedures() != null && u.getProcedures().getCost() != null)
                .mapToDouble(u -> u.getProcedures().getCost())
                .sum();
    }

    @Override
    public List<Undergoes> getProceduresByPatient(Integer patientSsn) {
        return undergoesRepository.findAll()
                .stream()
                .filter(u -> u.getId().getPatient().equals(patientSsn))
                .collect(Collectors.toList());
    }

    @Override
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
}