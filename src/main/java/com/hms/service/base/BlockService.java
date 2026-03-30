package com.hms.service.base;

import com.hms.entity.Block;
//import com.hms.entity.Block;
import com.hms.entity.BlockId;
import java.util.List;

public interface BlockService {

    Block saveBlock(Block block);

    List<Block> getAllBlocks();

    Block getBlockById(BlockId id);

    void deleteBlock(BlockId id);
}