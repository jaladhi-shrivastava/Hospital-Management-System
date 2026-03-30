package com.hms.service.base.impl;

import com.hms.entity.Block;
//import com.hms.entity.Block;
import com.hms.entity.BlockId;
import com.hms.repository.BlockRepository;
import com.hms.service.base.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    private BlockRepository blockRepository;

    @Override
    public Block saveBlock(Block block) {
        return blockRepository.save(block);
    }

    @Override
    public List<Block> getAllBlocks() {
        return blockRepository.findAll();
    }

    @Override
    public Block getBlockById(BlockId id) {
        return blockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Block not found"));
    }

    @Override
    public void deleteBlock(BlockId id) {
        Block block = blockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Block not found"));

        blockRepository.delete(block);
    }
}