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

    @Query("SELECT u FROM Undergoes u " +
            "LEFT JOIN FETCH u.patient " +
            "LEFT JOIN FETCH u.procedures " +
            "LEFT JOIN FETCH u.physician " +
            "LEFT JOIN FETCH u.stay " +
            "LEFT JOIN FETCH u.assistingNurse")
    List<Undergoes> findAllWithDetails();

    @Query("SELECT u FROM Undergoes u " +
            "LEFT JOIN FETCH u.patient " +
            "LEFT JOIN FETCH u.procedures " +
            "LEFT JOIN FETCH u.physician " +
            "LEFT JOIN FETCH u.stay " +
            "LEFT JOIN FETCH u.assistingNurse " +
            "WHERE u.id.patient = :patientSsn")
    List<Undergoes> findByPatientSsn(@Param("patientSsn") Integer patientSsn);

    @Query("SELECT u FROM Undergoes u " +
            "LEFT JOIN FETCH u.patient " +
            "LEFT JOIN FETCH u.procedures " +
            "LEFT JOIN FETCH u.physician " +
            "LEFT JOIN FETCH u.stay " +
            "LEFT JOIN FETCH u.assistingNurse " )
    List<Undergoes> findRecentUndergoes(@Param("since") LocalDateTime since);
}