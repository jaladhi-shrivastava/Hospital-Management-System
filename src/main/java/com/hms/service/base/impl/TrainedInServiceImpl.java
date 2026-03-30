package com.hms.service.base.impl;

import com.hms.entity.TrainedIn;
import com.hms.entity.TrainedInId;
import com.hms.exception.ResourceNotFoundException;
import com.hms.repository.TrainedInRepository;
import com.hms.service.base.TrainedInService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrainedInServiceImpl implements TrainedInService {

    private final TrainedInRepository trainedInRepository;

    @Override
    public List<TrainedIn> getAllTrainedIn() {
        return trainedInRepository.findAll();
    }

    @Override
    public Optional<TrainedIn> getTrainedInById(TrainedInId id) {
        return trainedInRepository.findById(id);
    }

    @Override
    public List<TrainedIn> getByPhysician(Integer physicianId) {
        return trainedInRepository.findById_Physician(physicianId);
    }

    @Override
    public List<TrainedIn> getByProcedure(Integer procedureCode) {
        return trainedInRepository.findById_Treatment(procedureCode);
    }

    @Override
    @Transactional
    public TrainedIn saveTrainedIn(TrainedIn trainedIn) {
        return trainedInRepository.save(trainedIn);
    }

    @Override
    @Transactional
    public TrainedIn updateCertification(TrainedInId id, TrainedIn updated) {
        TrainedIn existing = trainedInRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "TrainedIn record not found for physician: " + id.getPhysician()));
        existing.setCertificationDate(updated.getCertificationDate());
        existing.setCertificationExpires(updated.getCertificationExpires());
        return trainedInRepository.save(existing);
    }

    @Override
    @Transactional
    public void deleteTrainedIn(TrainedInId id) {
        if (!trainedInRepository.existsById(id)) {
            throw new ResourceNotFoundException("TrainedIn record not found");
        }
        trainedInRepository.deleteById(id);
    }
}
