package com.example.mobileapp;

public class AdminClass {

    private String user;
    private String job;
    private String faculty;
    private String type;

    public AdminClass(){

    }

    public AdminClass(String user, String job, String faculty, String type) {
        this.user = user;
        this.job = job;
        this.faculty = faculty;
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public String getJob() {
        return job;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getType() {
        return type;
    }
}
