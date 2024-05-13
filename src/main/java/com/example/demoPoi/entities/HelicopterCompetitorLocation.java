package com.example.demoPoi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "HELICOPTER_COMPETITOR_LOCATION")
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

    public HelicopterCompetitorLocation(Integer id, String name, String rmNm, String amNm, String cityNm, String timeStart, String userId, String userNm, String dateOccur, String regKId, Date regDt, String updKId, Date updDt) {
        this.id = id;
        this.name = name;
        this.rmNm = rmNm;
        this.amNm = amNm;
        this.cityNm = cityNm;
        this.timeStart = timeStart;
        this.userId = userId;
        this.userNm = userNm;
        this.dateOccur = dateOccur;
        this.regKId = regKId;
        this.regDt = regDt;
        this.updKId = updKId;
        this.updDt = updDt;
    }

    public HelicopterCompetitorLocation() {
    }

    public static HelicopterCompetitorLocationBuilder builder() {
        return new HelicopterCompetitorLocationBuilder();
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getRmNm() {
        return this.rmNm;
    }

    public String getAmNm() {
        return this.amNm;
    }

    public String getCityNm() {
        return this.cityNm;
    }

    public String getTimeStart() {
        return this.timeStart;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserNm() {
        return this.userNm;
    }

    public String getDateOccur() {
        return this.dateOccur;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setRmNm(String rmNm) {
        this.rmNm = rmNm;
    }

    public void setAmNm(String amNm) {
        this.amNm = amNm;
    }

    public void setCityNm(String cityNm) {
        this.cityNm = cityNm;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    public void setDateOccur(String dateOccur) {
        this.dateOccur = dateOccur;
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

    public String toString() {
        return "HelicopterCompetitorLocation(id=" + this.getId() + ", name=" + this.getName() + ", rmNm=" + this.getRmNm() + ", amNm=" + this.getAmNm() + ", cityNm=" + this.getCityNm() + ", timeStart=" + this.getTimeStart() + ", userId=" + this.getUserId() + ", userNm=" + this.getUserNm() + ", dateOccur=" + this.getDateOccur() + ", regKId=" + this.getRegKId() + ", regDt=" + this.getRegDt() + ", updKId=" + this.getUpdKId() + ", updDt=" + this.getUpdDt() + ")";
    }

    public static class HelicopterCompetitorLocationBuilder {
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

        HelicopterCompetitorLocationBuilder() {
        }

        public HelicopterCompetitorLocationBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public HelicopterCompetitorLocationBuilder name(String name) {
            this.name = name;
            return this;
        }

        public HelicopterCompetitorLocationBuilder rmNm(String rmNm) {
            this.rmNm = rmNm;
            return this;
        }

        public HelicopterCompetitorLocationBuilder amNm(String amNm) {
            this.amNm = amNm;
            return this;
        }

        public HelicopterCompetitorLocationBuilder cityNm(String cityNm) {
            this.cityNm = cityNm;
            return this;
        }

        public HelicopterCompetitorLocationBuilder timeStart(String timeStart) {
            this.timeStart = timeStart;
            return this;
        }

        public HelicopterCompetitorLocationBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public HelicopterCompetitorLocationBuilder userNm(String userNm) {
            this.userNm = userNm;
            return this;
        }

        public HelicopterCompetitorLocationBuilder dateOccur(String dateOccur) {
            this.dateOccur = dateOccur;
            return this;
        }

        public HelicopterCompetitorLocationBuilder regKId(String regKId) {
            this.regKId = regKId;
            return this;
        }

        public HelicopterCompetitorLocationBuilder regDt(Date regDt) {
            this.regDt = regDt;
            return this;
        }

        public HelicopterCompetitorLocationBuilder updKId(String updKId) {
            this.updKId = updKId;
            return this;
        }

        public HelicopterCompetitorLocationBuilder updDt(Date updDt) {
            this.updDt = updDt;
            return this;
        }

        public HelicopterCompetitorLocation build() {
            return new HelicopterCompetitorLocation(this.id, this.name, this.rmNm, this.amNm, this.cityNm, this.timeStart, this.userId, this.userNm, this.dateOccur, this.regKId, this.regDt, this.updKId, this.updDt);
        }

        public String toString() {
            return "HelicopterCompetitorLocation.HelicopterCompetitorLocationBuilder(id=" + this.id + ", name=" + this.name + ", rmNm=" + this.rmNm + ", amNm=" + this.amNm + ", cityNm=" + this.cityNm + ", timeStart=" + this.timeStart + ", userId=" + this.userId + ", userNm=" + this.userNm + ", dateOccur=" + this.dateOccur + ", regKId=" + this.regKId + ", regDt=" + this.regDt + ", updKId=" + this.updKId + ", updDt=" + this.updDt + ")";
        }
    }
}
