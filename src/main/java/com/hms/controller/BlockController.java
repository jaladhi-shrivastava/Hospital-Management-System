package com.hms.controller;

import com.hms.entity.Block;
import com.hms.entity.BlockId;
import com.hms.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blocks")
public class BlockController {

    @Autowired
    private BlockService blockService;

    @GetMapping
    public List<Block> getAllBlocks() {
        return blockService.getAllBlocks();
    }

    @GetMapping("/{floor}/{code}")
    public Block getBlockById(@PathVariable Integer floor,
                              @PathVariable Integer code) {

        BlockId id = new BlockId(floor, code);
        return blockService.getBlockById(id);
    }

    @PostMapping
    public Block createBlock(@RequestBody Block block) {
        return blockService.saveBlock(block);
    }

    @DeleteMapping("/{floor}/{code}")
    public String deleteBlock(@PathVariable Integer floor,
                              @PathVariable Integer code) {

        BlockId id = new BlockId(floor, code);
        blockService.deleteBlock(id);

        return "Block deleted successfully";
    }
}