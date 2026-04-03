package com.hms.repository;

import com.hms.entity.OnCall;
import com.hms.entity.OnCallId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface OnCallRepository extends JpaRepository<OnCall, OnCallId> {

    @Query("SELECT o FROM OnCall o LEFT JOIN FETCH o.nurse LEFT JOIN FETCH o.block ")
    List<OnCall> findCurrentlyOnCall();

    @Query("SELECT o FROM OnCall o " +
            "LEFT JOIN FETCH o.nurse " +
            "LEFT JOIN FETCH o.block " +
            "WHERE o.id.nurse = :nurseId")
    List<OnCall> findById_Nurse(@Param("nurseId") Integer nurseId);

    @Query("SELECT o FROM OnCall o " +
            "LEFT JOIN FETCH o.nurse " +
            "LEFT JOIN FETCH o.block " +
            "WHERE o.id.blockFloor = :blockFloor AND o.id.blockCode = :blockCode")
    List<OnCall> findById_BlockFloorAndId_BlockCode(
            @Param("blockFloor") Integer blockFloor,
            @Param("blockCode") Integer blockCode);
}