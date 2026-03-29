package com.hms.repository;

import com.hms.entity.OnCall;
import com.hms.entity.OnCallId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OnCallRepository extends JpaRepository<OnCall, OnCallId> {
    @Query("SELECT o FROM OnCall o WHERE :now BETWEEN o.onCallStart AND o.onCallEnd")
    List<OnCall> findCurrentlyOnCall(@Param("now") LocalDateTime now);

    List<OnCall> findById_Nurse(Integer nurseId);

    List<OnCall> findById_BlockFloorAndId_BlockCode(
            Integer blockFloor, Integer blockCode);
}
