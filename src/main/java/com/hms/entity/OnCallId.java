package com.hms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import java.io.Serializable;

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
}
