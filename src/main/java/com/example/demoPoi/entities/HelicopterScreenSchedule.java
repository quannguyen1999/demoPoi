package com.example.demoPoi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "HELICOPTER_SCREEN_SCHEDULE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class HelicopterScreenSchedule {
    @Id
    private Integer id;
    private String movNm;
    private String scnDy;
    private String scnFrTm;
    private String scnToTm;
    private String name;
    private String screenNm;
    private String seatCnt;
    private String bizFrDy;
    private String bizToDy;
    private String dateOccur;
    private String userId;
    private String userNm;
    private String regKId;
    private Date regDt;
    private String updKId;
    private Date updDt;
}
