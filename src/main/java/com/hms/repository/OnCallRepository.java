package com.hms.repository;

import com.hms.entity.OnCall;
import com.hms.entity.OnCallId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OnCallRepository extends JpaRepository<OnCall, OnCallId> {

    List<OnCall> findById_Nurse(Integer nurseId);

    List<OnCall> findById_BlockFloorAndId_BlockCode(
            Integer blockFloor, Integer blockCode);
}
