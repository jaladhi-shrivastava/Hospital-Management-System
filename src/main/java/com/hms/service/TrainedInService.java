package com.hms.service;

import com.hms.entity.TrainedIn;
import com.hms.entity.TrainedInId;
import java.util.List;
import java.util.Optional;

public interface TrainedInService {

    List<TrainedIn> getAllTrainedIn();

    Optional<TrainedIn> getTrainedInById(TrainedInId id);

    List<TrainedIn> getByPhysician(Integer physicianId);

    List<TrainedIn> getByProcedure(Integer procedureCode);

    TrainedIn saveTrainedIn(TrainedIn trainedIn);

    TrainedIn updateCertification(TrainedInId id, TrainedIn updated);

    void deleteTrainedIn(TrainedInId id);
}
