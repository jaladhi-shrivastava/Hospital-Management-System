package com.hms.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OnCallId implements Serializable {

    @Column(name = "Nurse")
    private Integer nurse;

    @Column(name = "BlockFloor")
    private Integer blockFloor;

    @Column(name = "BlockCode")
    private Integer blockCode;

    @Column(name = "OnCallStart")
    private LocalDateTime onCallStart;

    @Column(name = "OnCallEnd")
    private LocalDateTime onCallEnd;
}