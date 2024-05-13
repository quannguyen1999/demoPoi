package com.example.demoPoi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "HELICOPTER_SCREEN_SCHEDULE")
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

    public HelicopterScreenSchedule(Integer id, String movNm, String scnDy, String scnFrTm, String scnToTm, String name, String screenNm, String seatCnt, String bizFrDy, String bizToDy, String dateOccur, String userId, String userNm, String regKId, Date regDt, String updKId, Date updDt) {
        this.id = id;
        this.movNm = movNm;
        this.scnDy = scnDy;
        this.scnFrTm = scnFrTm;
        this.scnToTm = scnToTm;
        this.name = name;
        this.screenNm = screenNm;
        this.seatCnt = seatCnt;
        this.bizFrDy = bizFrDy;
        this.bizToDy = bizToDy;
        this.dateOccur = dateOccur;
        this.userId = userId;
        this.userNm = userNm;
        this.regKId = regKId;
        this.regDt = regDt;
        this.updKId = updKId;
        this.updDt = updDt;
    }

    public HelicopterScreenSchedule() {
    }

    public static HelicopterScreenScheduleBuilder builder() {
        return new HelicopterScreenScheduleBuilder();
    }

    public Integer getId() {
        return this.id;
    }

    public String getMovNm() {
        return this.movNm;
    }

    public String getScnDy() {
        return this.scnDy;
    }

    public String getScnFrTm() {
        return this.scnFrTm;
    }

    public String getScnToTm() {
        return this.scnToTm;
    }

    public String getName() {
        return this.name;
    }

    public String getScreenNm() {
        return this.screenNm;
    }

    public String getSeatCnt() {
        return this.seatCnt;
    }

    public String getBizFrDy() {
        return this.bizFrDy;
    }

    public String getBizToDy() {
        return this.bizToDy;
    }

    public String getDateOccur() {
        return this.dateOccur;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserNm() {
        return this.userNm;
    }

    public String getRegKId() {
        return this.regKId;
    }

    public Date getRegDt() {
        return this.regDt;
    }

    public String getUpdKId() {
        return this.updKId;
    }

    public Date getUpdDt() {
        return this.updDt;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMovNm(String movNm) {
        this.movNm = movNm;
    }

    public void setScnDy(String scnDy) {
        this.scnDy = scnDy;
    }

    public void setScnFrTm(String scnFrTm) {
        this.scnFrTm = scnFrTm;
    }

    public void setScnToTm(String scnToTm) {
        this.scnToTm = scnToTm;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScreenNm(String screenNm) {
        this.screenNm = screenNm;
    }

    public void setSeatCnt(String seatCnt) {
        this.seatCnt = seatCnt;
    }

    public void setBizFrDy(String bizFrDy) {
        this.bizFrDy = bizFrDy;
    }

    public void setBizToDy(String bizToDy) {
        this.bizToDy = bizToDy;
    }

    public void setDateOccur(String dateOccur) {
        this.dateOccur = dateOccur;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    public void setRegKId(String regKId) {
        this.regKId = regKId;
    }

    public void setRegDt(Date regDt) {
        this.regDt = regDt;
    }

    public void setUpdKId(String updKId) {
        this.updKId = updKId;
    }

    public void setUpdDt(Date updDt) {
        this.updDt = updDt;
    }

    public static class HelicopterScreenScheduleBuilder {
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

        HelicopterScreenScheduleBuilder() {
        }

        public HelicopterScreenScheduleBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public HelicopterScreenScheduleBuilder movNm(String movNm) {
            this.movNm = movNm;
            return this;
        }

        public HelicopterScreenScheduleBuilder scnDy(String scnDy) {
            this.scnDy = scnDy;
            return this;
        }

        public HelicopterScreenScheduleBuilder scnFrTm(String scnFrTm) {
            this.scnFrTm = scnFrTm;
            return this;
        }

        public HelicopterScreenScheduleBuilder scnToTm(String scnToTm) {
            this.scnToTm = scnToTm;
            return this;
        }

        public HelicopterScreenScheduleBuilder name(String name) {
            this.name = name;
            return this;
        }

        public HelicopterScreenScheduleBuilder screenNm(String screenNm) {
            this.screenNm = screenNm;
            return this;
        }

        public HelicopterScreenScheduleBuilder seatCnt(String seatCnt) {
            this.seatCnt = seatCnt;
            return this;
        }

        public HelicopterScreenScheduleBuilder bizFrDy(String bizFrDy) {
            this.bizFrDy = bizFrDy;
            return this;
        }

        public HelicopterScreenScheduleBuilder bizToDy(String bizToDy) {
            this.bizToDy = bizToDy;
            return this;
        }

        public HelicopterScreenScheduleBuilder dateOccur(String dateOccur) {
            this.dateOccur = dateOccur;
            return this;
        }

        public HelicopterScreenScheduleBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public HelicopterScreenScheduleBuilder userNm(String userNm) {
            this.userNm = userNm;
            return this;
        }

        public HelicopterScreenScheduleBuilder regKId(String regKId) {
            this.regKId = regKId;
            return this;
        }

        public HelicopterScreenScheduleBuilder regDt(Date regDt) {
            this.regDt = regDt;
            return this;
        }

        public HelicopterScreenScheduleBuilder updKId(String updKId) {
            this.updKId = updKId;
            return this;
        }

        public HelicopterScreenScheduleBuilder updDt(Date updDt) {
            this.updDt = updDt;
            return this;
        }

        public HelicopterScreenSchedule build() {
            return new HelicopterScreenSchedule(this.id, this.movNm, this.scnDy, this.scnFrTm, this.scnToTm, this.name, this.screenNm, this.seatCnt, this.bizFrDy, this.bizToDy, this.dateOccur, this.userId, this.userNm, this.regKId, this.regDt, this.updKId, this.updDt);
        }

        public String toString() {
            return "HelicopterScreenSchedule.HelicopterScreenScheduleBuilder(id=" + this.id + ", movNm=" + this.movNm + ", scnDy=" + this.scnDy + ", scnFrTm=" + this.scnFrTm + ", scnToTm=" + this.scnToTm + ", name=" + this.name + ", screenNm=" + this.screenNm + ", seatCnt=" + this.seatCnt + ", bizFrDy=" + this.bizFrDy + ", bizToDy=" + this.bizToDy + ", dateOccur=" + this.dateOccur + ", userId=" + this.userId + ", userNm=" + this.userNm + ", regKId=" + this.regKId + ", regDt=" + this.regDt + ", updKId=" + this.updKId + ", updDt=" + this.updDt + ")";
        }
    }
}
