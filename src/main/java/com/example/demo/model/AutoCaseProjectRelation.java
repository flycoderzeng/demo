package com.example.demo.model;

import java.util.Date;

public class AutoCaseProjectRelation {
    private Integer id;

    private String autoCaseName;

    private Date createTime;

    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAutoCaseName() {
        return autoCaseName;
    }

    public void setAutoCaseName(String autoCaseName) {
        this.autoCaseName = autoCaseName == null ? null : autoCaseName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}