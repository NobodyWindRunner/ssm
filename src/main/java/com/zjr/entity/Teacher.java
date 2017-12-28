package com.zjr.entity;

public class Teacher {
    private Integer id;

    private String teaname;

    private String teaclass;

    private Integer teaage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeaname() {
        return teaname;
    }

    public void setTeaname(String teaname) {
        this.teaname = teaname == null ? null : teaname.trim();
    }

    public String getTeaclass() {
        return teaclass;
    }

    public void setTeaclass(String teaclass) {
        this.teaclass = teaclass == null ? null : teaclass.trim();
    }

    public Integer getTeaage() {
        return teaage;
    }

    public void setTeaage(Integer teaage) {
        this.teaage = teaage;
    }
}