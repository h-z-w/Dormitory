package com.example.dormitory.model;

import java.io.Serializable;

public class Room implements Serializable {
    public static final String TBL_ROOM = "CREATE TABLE  student(" +
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
    private String classroom;
    private int xh;
    private String  sex;
    private String tel;
    private String data;
    private String shushe;

    public Room(int id, String name, String classroom, int xh, String sex, String tel, String shushe,String data) {
        this.id = id;
        this.name = name;
        this.classroom = classroom;
        this.xh = xh;
        this.sex = sex;
        this.tel = tel;
        this.shushe = shushe;
        this.data = data;
    }

    public Room() {

    }

    public static String getTblRoom() {
        return TBL_ROOM;
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

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getShushe() {
        return shushe;
    }

    public void setShushe(String shushe) {
        this.shushe = shushe;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classroom='" + classroom + '\'' +
                ", xh=" + xh +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                ", shushe='" + shushe + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
