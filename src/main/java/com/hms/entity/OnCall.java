package com.hms.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
class OnCallId implements Serializable {
    @Column(name = "Nurse")       private Integer nurse;
    @Column(name = "BlockFloor")  private Integer blockFloor;
    @Column(name = "BlockCode")   private Integer blockCode;
}

@Entity
@Table(name = "on_call")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OnCall {

    @EmbeddedId
    private OnCallId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Nurse", insertable = false, updatable = false)
    private Nurse nurse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "BlockFloor", referencedColumnName = "BlockFloor", insertable = false, updatable = false),
            @JoinColumn(name = "BlockCode",  referencedColumnName = "BlockCode",  insertable = false, updatable = false)
    })
    private Block block;

    @Column(name = "OnCallStart")
    private LocalDateTime onCallStart;

    @Column(name = "OnCallEnd")
    private LocalDateTime onCallEnd;
}
