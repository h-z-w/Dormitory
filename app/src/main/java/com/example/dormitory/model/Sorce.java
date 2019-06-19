package com.example.dormitory.model;

import java.io.Serializable;

public class Sorce implements Serializable {
    public static  final String TBL_SORCE ="CREATE TABLE  sorce(" +
            "  id integer PRIMARY KEY autoincrement ," +
            "  sushe integer NOT NULL ," +
            "  marks  integer NOT NULL " +
            "  submission_date DATE";
    private int id;
    private int sushe;
    private int marks;
    private String data;
    public Sorce() {
    }

    public Sorce(int sushe, int marks, String data) {
        this.sushe = sushe;
        this.marks = marks;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSushe() {
        return sushe;
    }

    public void setSushe(int sushe) {
        this.sushe = sushe;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Sorce{" +
                "id=" + id +
                ", sushe=" + sushe +
                ", marks=" + marks +
                ", data='" + data + '\'' +
                '}';
    }
}
