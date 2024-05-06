package com.example.demoPoi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "HELICOPTER_COMPETITOR_LOCATION")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class HelicopterCompetitorLocation {
    @Id
    private Integer id;
    private String name;
    private String rmNm;
    private String amNm;
    private String cityNm;
    private String timeStart;
    private String userId;
    private String userNm;
    private String dateOccur;
    private String regKId;
    private Date regDt;
    private String updKId;
    private Date updDt;
}
