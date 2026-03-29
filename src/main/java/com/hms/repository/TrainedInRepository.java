package com.hms.repository;

import com.hms.entity.TrainedIn;
import com.hms.entity.TrainedInId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TrainedInRepository extends JpaRepository<TrainedIn, TrainedInId> {

    List<TrainedIn> findById_Physician(Integer physicianId);

    List<TrainedIn> findById_Treatment(Integer procedureCode);
}
