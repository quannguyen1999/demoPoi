package com.example.demoPoi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "HELICOPTER_HST")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class HelicopterHistory {
    @Id
    private Integer id;
    private String nameFile;
    private String sizeFile;
    private String timeStart;
    private String endStart;
    private String dateRun;
    private String status;
    private String messageError;
    private String dateOccur;
    private String userId;
    private String regKId;
    private Date regDt;
    private String updKId;
    private Date updDt;
}
