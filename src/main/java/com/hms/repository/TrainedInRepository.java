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

    // All procedures a physician is certified for — JOIN FETCH to load physician and treatment
    @Query("SELECT t FROM TrainedIn t " +
            "LEFT JOIN FETCH t.physician " +
            "LEFT JOIN FETCH t.treatment " +
            "WHERE t.id.physician = :physicianId")
    List<TrainedIn> findById_Physician(@Param("physicianId") Integer physicianId);

    // All physicians certified for a specific procedure — JOIN FETCH both sides
    @Query("SELECT t FROM TrainedIn t " +
            "LEFT JOIN FETCH t.physician " +
            "LEFT JOIN FETCH t.treatment " +
            "WHERE t.id.treatment = :procedureCode")
    List<TrainedIn> findById_Treatment(@Param("procedureCode") Integer procedureCode);

    // All records with both sides fetched — used for certification expiry check
    @Query("SELECT t FROM TrainedIn t " +
            "LEFT JOIN FETCH t.physician " +
            "LEFT JOIN FETCH t.treatment")
    List<TrainedIn> findAllWithDetails();
}