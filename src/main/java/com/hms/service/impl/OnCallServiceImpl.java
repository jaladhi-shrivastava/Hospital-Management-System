package com.hms.service.impl;

import com.hms.entity.OnCall;
import com.hms.entity.OnCallId;
import com.hms.exception.ResourceNotFoundException;
import com.hms.repository.OnCallRepository;
import com.hms.service.OnCallService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OnCallServiceImpl implements OnCallService {

    private final OnCallRepository onCallRepository;

    @Override
    public List<OnCall> getAllOnCallRecords() {
        return onCallRepository.findAll();
    }

    @Override
    public Optional<OnCall> getOnCallById(OnCallId id) {
        return onCallRepository.findById(id);
    }

    @Override
    public List<OnCall> getOnCallByNurse(Integer nurseId) {
        return onCallRepository.findById_Nurse(nurseId);
    }

    @Override
    public List<OnCall> getOnCallByBlock(Integer blockFloor, Integer blockCode) {
        return onCallRepository.findById_BlockFloorAndId_BlockCode(blockFloor, blockCode);
    }

    @Override
    @Transactional
    public OnCall saveOnCall(OnCall onCall) {
        return onCallRepository.save(onCall);
    }

    @Override
    @Transactional
    public void deleteOnCall(OnCallId id) {
        if (!onCallRepository.existsById(id)) {
            throw new ResourceNotFoundException("OnCall record not found");
        }
        onCallRepository.deleteById(id);
    }
}
