package com.example.demo.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Document(collection = "notification_inbox_collection")
public class User {
    @Id
    private String userId;
    @NotNull(message = "Message not null")
    private String notiMsg;

    private Date receiverTime;

    private Date changeTime;
    @Min(0)
    @Max(1)
    private Integer status;

    public User() {

    }

    public User(String userId, String notiMsg, Date receiverTime, Date changeTime, Integer status) {
        this.userId = userId;
        this.notiMsg = notiMsg;
        this.receiverTime = receiverTime;
        this.changeTime = changeTime;
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNotiMsg() {
        return notiMsg;
    }

    public void setNotiMsg(String notiMsg) {
        this.notiMsg = notiMsg;
    }

    public Date getReceiverTime() {
        return receiverTime;
    }

    public void setReceiverTime(Date receiverTime) {
        this.receiverTime = receiverTime;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
