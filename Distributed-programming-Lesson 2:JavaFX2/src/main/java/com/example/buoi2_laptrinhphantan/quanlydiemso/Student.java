package com.example.buoi2_laptrinhphantan.quanlydiemso;

public class Student {
    private String id;
    private String name;
    private String clazz;
    private String gender;
    private String address;
    private double score;

    public Student(String id, String name, String clazz, String gender, String address, double score) {
        this.id = id;
        this.name = name;
        this.clazz = clazz;
        this.gender = gender;
        this.address = address;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClazz() {
        return clazz;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public double getScore() {
        return score;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
