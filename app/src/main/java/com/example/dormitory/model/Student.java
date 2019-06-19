package com.example.dormitory.model;

import java.io.Serializable;

public class Student implements Serializable {
    public static  final String TBL_STUDENT ="CREATE TABLE  student(" +
            "  id integer PRIMARY KEY autoincrement ," +
            "  name VARCHAR(100) NOT NULL ," +
            "  classroom VARCHAR(40) NOT NULL ," +
            "  xh integer(10) NOT NULL ," +
            "  sex VARCHAR(40) NOT NULL ," +
            "  sushe integer(8) NOT NULL ," +
            "  tel varchar(11) NOT NULL ," +
            "  submission_date DATE )";
    private int id;
    private String name;
    private String className;
    private int xh;
    private String sex;
    private int shuShe;
    private String  tel;
    private String submissionDate;

    public Student() {
    }

    public Student(String name, String className, int xh, String sex, int shuShe, String tel, String submissionDate) {
        this.name = name;
        this.className = className;
        this.xh = xh;
        this.sex = sex;
        this.shuShe = shuShe;
        this.tel = tel;
        this.submissionDate = submissionDate;
    }

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
