package com.hms.repository;

import com.hms.entity.TrainedIn;
import com.hms.entity.TrainedInId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TrainedInRepository extends JpaRepository<TrainedIn, TrainedInId> {

    // All procedures a physician is certified for
    List<TrainedIn> findById_Physician(Integer physicianId);

    // All physicians certified for a specific procedure/treatment
    List<TrainedIn> findById_Treatment(Integer procedureCode);
}
