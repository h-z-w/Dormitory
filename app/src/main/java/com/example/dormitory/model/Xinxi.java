package com.example.dormitory.model;

import java.io.Serializable;

public class Xinxi implements Serializable {
    private int id;
    private String name;
    private String className;
    private int xh;
    private String sex;
    private int shuShe;
    private String  tel;
    private String submissionDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getXh() {
        return xh;
    }

    public void setXh(int xh) {
        this.xh = xh;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getShuShe() {
        return shuShe;
    }

    public void setShuShe(int shuShe) {
        this.shuShe = shuShe;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    @Override
    public String toString() {
        return "Xinxi{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", xh=" + xh +
                ", sex='" + sex + '\'' +
                ", shuShe=" + shuShe +
                ", tel='" + tel + '\'' +
                ", submissionDate='" + submissionDate + '\'' +
                '}';
    }
}
