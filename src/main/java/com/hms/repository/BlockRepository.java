package com.hms.repository;

//import com.hms.entity.Block;
import com.hms.entity.Block;
import com.hms.entity.BlockId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepository extends JpaRepository<Block, BlockId> {
}