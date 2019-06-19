package com.example.dormitory.model;

import java.io.Serializable;

public class Room extends Student implements Serializable {
    public static final String TBL_ROOM = "CREATE TABLE  room(" +
            "  id integer PRIMARY KEY autoincrement ," +
            "  sushe integer NOT NULL ," +
            "  yzpeople  integer NOT NULL ," +
            "  szpeople integer NOT NULL" +
            "cost integer, "  +
            "remark varchar(200)))";

    private int id;
    private int sushe;
    private int yzpeople;
    private int szpeople;
    private int cost;
    private String remark;




    String selectSQL = "select * from room where yzpeople > szpeople";  // 查询所有没住满的宿舍信息列表
    public Room() {

    }

    public Room(int id, int sushe, int yzpeople, int szpeople, int cost, String remark, String selectSQL) {
        this.id = id;
        this.sushe = sushe;
        this.yzpeople = yzpeople;
        this.szpeople = szpeople;
        this.cost = cost;
        this.remark = remark;
        this.selectSQL = selectSQL;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getSushe() {
        return sushe;
    }

    public void setSushe(int sushe) {
        this.sushe = sushe;
    }

    public int getYzpeople() {
        return yzpeople;
    }

    public void setYzpeople(int yzpeople) {
        this.yzpeople = yzpeople;
    }

    public int getSzpeople() {
        return szpeople;
    }

    public void setSzpeople(int szpeople) {
        this.szpeople = szpeople;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSelectSQL() {
        return selectSQL;
    }

    public void setSelectSQL(String selectSQL) {
        this.selectSQL = selectSQL;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", sushe=" + sushe +
                ", yzpeople=" + yzpeople +
                ", szpeople=" + szpeople +
                ", cost=" + cost +
                ", remark='" + remark + '\'' +
                ", selectSQL='" + selectSQL + '\'' +
                '}';
    }
}
