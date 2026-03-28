package com.hms.repository;

import com.hms.entity.Undergoes;
import com.hms.entity.UndergoesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UndergoesRepository extends JpaRepository<Undergoes, UndergoesId> {

    // Used by AdminModule: get all procedures for a specific patient
    @Query("SELECT u FROM Undergoes u WHERE u.id.patient = :patientSsn")
    List<Undergoes> findByPatientSsn(@Param("patientSsn") Integer patientSsn);

    // Used by PatientModule: procedures in last 30 days
    @Query("SELECT u FROM Undergoes u WHERE u.id.dateUndergoes >= :since")
    List<Undergoes> findRecentUndergoes(@Param("since") LocalDateTime since);
}