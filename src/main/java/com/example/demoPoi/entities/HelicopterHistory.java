package com.example.demoPoi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "HELICOPTER_HST")
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

    public HelicopterHistory(Integer id, String nameFile, String sizeFile, String timeStart, String endStart, String dateRun, String status, String messageError, String dateOccur, String userId, String regKId, Date regDt, String updKId, Date updDt) {
        this.id = id;
        this.nameFile = nameFile;
        this.sizeFile = sizeFile;
        this.timeStart = timeStart;
        this.endStart = endStart;
        this.dateRun = dateRun;
        this.status = status;
        this.messageError = messageError;
        this.dateOccur = dateOccur;
        this.userId = userId;
        this.regKId = regKId;
        this.regDt = regDt;
        this.updKId = updKId;
        this.updDt = updDt;
    }

    public HelicopterHistory() {
    }

    public static HelicopterHistoryBuilder builder() {
        return new HelicopterHistoryBuilder();
    }

    public Integer getId() {
        return this.id;
    }

    public String getNameFile() {
        return this.nameFile;
    }

    public String getSizeFile() {
        return this.sizeFile;
    }

    public String getTimeStart() {
        return this.timeStart;
    }

    public String getEndStart() {
        return this.endStart;
    }

    public String getDateRun() {
        return this.dateRun;
    }

    public String getStatus() {
        return this.status;
    }

    public String getMessageError() {
        return this.messageError;
    }

    public String getDateOccur() {
        return this.dateOccur;
    }

    public String getUserId() {
        return this.userId;
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

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public void setSizeFile(String sizeFile) {
        this.sizeFile = sizeFile;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public void setEndStart(String endStart) {
        this.endStart = endStart;
    }

    public void setDateRun(String dateRun) {
        this.dateRun = dateRun;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    public void setDateOccur(String dateOccur) {
        this.dateOccur = dateOccur;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public static class HelicopterHistoryBuilder {
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

        HelicopterHistoryBuilder() {
        }

        public HelicopterHistoryBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public HelicopterHistoryBuilder nameFile(String nameFile) {
            this.nameFile = nameFile;
            return this;
        }

        public HelicopterHistoryBuilder sizeFile(String sizeFile) {
            this.sizeFile = sizeFile;
            return this;
        }

        public HelicopterHistoryBuilder timeStart(String timeStart) {
            this.timeStart = timeStart;
            return this;
        }

        public HelicopterHistoryBuilder endStart(String endStart) {
            this.endStart = endStart;
            return this;
        }

        public HelicopterHistoryBuilder dateRun(String dateRun) {
            this.dateRun = dateRun;
            return this;
        }

        public HelicopterHistoryBuilder status(String status) {
            this.status = status;
            return this;
        }

        public HelicopterHistoryBuilder messageError(String messageError) {
            this.messageError = messageError;
            return this;
        }

        public HelicopterHistoryBuilder dateOccur(String dateOccur) {
            this.dateOccur = dateOccur;
            return this;
        }

        public HelicopterHistoryBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public HelicopterHistoryBuilder regKId(String regKId) {
            this.regKId = regKId;
            return this;
        }

        public HelicopterHistoryBuilder regDt(Date regDt) {
            this.regDt = regDt;
            return this;
        }

        public HelicopterHistoryBuilder updKId(String updKId) {
            this.updKId = updKId;
            return this;
        }

        public HelicopterHistoryBuilder updDt(Date updDt) {
            this.updDt = updDt;
            return this;
        }

        public HelicopterHistory build() {
            return new HelicopterHistory(this.id, this.nameFile, this.sizeFile, this.timeStart, this.endStart, this.dateRun, this.status, this.messageError, this.dateOccur, this.userId, this.regKId, this.regDt, this.updKId, this.updDt);
        }

        public String toString() {
            return "HelicopterHistory.HelicopterHistoryBuilder(id=" + this.id + ", nameFile=" + this.nameFile + ", sizeFile=" + this.sizeFile + ", timeStart=" + this.timeStart + ", endStart=" + this.endStart + ", dateRun=" + this.dateRun + ", status=" + this.status + ", messageError=" + this.messageError + ", dateOccur=" + this.dateOccur + ", userId=" + this.userId + ", regKId=" + this.regKId + ", regDt=" + this.regDt + ", updKId=" + this.updKId + ", updDt=" + this.updDt + ")";
        }
    }
}
