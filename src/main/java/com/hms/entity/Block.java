package com.hms.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

// Composite Primary Key class
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
class BlockId implements Serializable {
    @Column(name = "BlockFloor")
    private Integer blockFloor;

    @Column(name = "BlockCode")
    private Integer blockCode;
}

@Entity
@Table(name = "block")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Block {

    @EmbeddedId
    private BlockId id;
}
