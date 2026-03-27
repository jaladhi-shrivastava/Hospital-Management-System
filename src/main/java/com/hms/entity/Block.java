package com.hms.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "block")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Block {

    @EmbeddedId
    private BlockId id;
}