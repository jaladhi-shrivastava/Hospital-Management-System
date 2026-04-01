package com.hms.service.module.admin;

import com.hms.dto.view.admin.AdminDashboardDTO;
import com.hms.dto.view.admin.AdminProcedureDTO;
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


    @Override
    @Transactional(readOnly = true)
    public AdminDashboardDTO getHospitalStatus() {
        Double revenue = getTotalRevenue();
        Map<String, Long> deptCounts = getDoctorCountPerDepartment();

        Map<String, Object> statusMap = new LinkedHashMap<>();
        statusMap.put("totalPatients",    patientRepository.count());
        statusMap.put("activeAdmissions", stayRepository.findActiveStays().size());
        statusMap.put("occupiedRooms",    stayRepository.findOccupiedRoomStays().size());
        statusMap.put("totalDepartments", departmentRepository.count());

        return new AdminDashboardDTO(revenue, deptCounts, statusMap);
    }


    @Override
    @Transactional(readOnly = true)
    public Double getTotalRevenue() {
        return undergoesRepository.findAllWithDetails()
                .stream()
                .filter(u -> u.getProcedures() != null && u.getProcedures().getCost() != null)
                .mapToDouble(u -> u.getProcedures().getCost())
                .sum();
    }


    @Override
    @Transactional(readOnly = true)
    public List<AdminProcedureDTO> getProceduresByPatient(Integer patientSsn) {
        List<Undergoes> list = undergoesRepository.findByPatientSsn(patientSsn);
        if (list.isEmpty()) {
            throw new com.hms.exception.ResourceNotFoundException(
                    "No procedures found for patient SSN: " + patientSsn);
        }
        return list.stream()
                .map(u -> new AdminProcedureDTO(
                        u.getId().getPatient(),
                        u.getId().getProcedures(),
                        u.getId().getStay(),
                        u.getId().getDateUndergoes(),
                        u.getProcedures() != null ? u.getProcedures().getName() : null,
                        u.getProcedures() != null ? u.getProcedures().getCost() : null,
                        u.getPhysician() != null ? u.getPhysician().getEmployeeId() : null,
                        u.getPhysician() != null ? u.getPhysician().getName() : null,
                        u.getAssistingNurse() != null ? u.getAssistingNurse().getEmployeeId() : null,
                        u.getAssistingNurse() != null ? u.getAssistingNurse().getName() : null
                ))
                .toList();
    }


    @Override
    @Transactional(readOnly = true)
    public Map<String, Long> getDoctorCountPerDepartment() {
        List<AffiliatedWith> all = affiliatedWithRepository.findAll();
        List<Department> departments = departmentRepository.findAll();

        Map<Integer, String> deptNames = departments.stream()
                .collect(Collectors.toMap(
                        Department::getDepartmentId,
                        Department::getName
                ));

        Map<String, Long> result = new LinkedHashMap<>();
        all.stream()
                .collect(Collectors.groupingBy(
                        a -> a.getId().getDepartment(),
                        Collectors.counting()
                ))
                .forEach((deptId, count) ->
                        result.put(deptNames.getOrDefault(deptId, "Dept-" + deptId), count));

        return result;
    }
}