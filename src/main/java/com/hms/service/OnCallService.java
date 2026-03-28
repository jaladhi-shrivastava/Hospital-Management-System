package com.hms.service;

import com.hms.entity.OnCall;
import com.hms.entity.OnCallId;
import java.util.List;
import java.util.Optional;

public interface OnCallService {

    List<OnCall> getAllOnCallRecords();

    Optional<OnCall> getOnCallById(OnCallId id);

    List<OnCall> getOnCallByNurse(Integer nurseId);

    List<OnCall> getOnCallByBlock(Integer blockFloor, Integer blockCode);

    OnCall saveOnCall(OnCall onCall);

    void deleteOnCall(OnCallId id);
}
