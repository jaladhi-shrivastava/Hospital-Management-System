package com.hms.repository;

import com.hms.entity.Undergoes;
import com.hms.entity.UndergoesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UndergoesRepository extends JpaRepository<Undergoes, UndergoesId> {
}