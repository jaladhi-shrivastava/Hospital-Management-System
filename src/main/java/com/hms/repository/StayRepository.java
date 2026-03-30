package com.hms.repository;

import com.hms.entity.Stay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StayRepository extends JpaRepository<Stay, Integer> {

    @Query("SELECT s FROM Stay s JOIN FETCH s.patient JOIN FETCH s.room")
    List<Stay> findActiveStays();

    @Query("SELECT s FROM Stay s LEFT JOIN FETCH s.patient JOIN FETCH s.room ")
    List<Stay> findOccupiedRoomStays();
}