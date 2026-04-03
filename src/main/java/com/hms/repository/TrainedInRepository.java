package com.hms.repository;

import com.hms.entity.TrainedIn;
import com.hms.entity.TrainedInId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainedInRepository extends JpaRepository<TrainedIn, TrainedInId> {

    @Query("SELECT t FROM TrainedIn t " +
            "LEFT JOIN FETCH t.physician " +
            "LEFT JOIN FETCH t.treatment " +
            "WHERE t.id.physician = :physicianId")
    List<TrainedIn> findById_Physician(@Param("physicianId") Integer physicianId);

    @Query("SELECT t FROM TrainedIn t " +
            "LEFT JOIN FETCH t.physician " +
            "LEFT JOIN FETCH t.treatment " +
            "WHERE t.id.treatment = :procedureCode")
    List<TrainedIn> findById_Treatment(@Param("procedureCode") Integer procedureCode);

    @Query("SELECT t FROM TrainedIn t " +
            "LEFT JOIN FETCH t.physician " +
            "LEFT JOIN FETCH t.treatment")
    List<TrainedIn> findAllWithDetails();
}