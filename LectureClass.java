package com.example.mobileapp;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class LectureClass {

    private String jobName;
    private String descr;
    private String salary;
    private String faculty;

    public LectureClass(){

    }

    public LectureClass(String jobName, String descr, String salary, String faculty) {
        this.jobName = jobName;
        this.descr = descr;
        this.salary = salary;
        this.faculty = faculty;
    }

    public String getJobName() {
        return jobName;
    }

    public String getDescr() {
        return descr;
    }

    public String getSalary() {
        return salary;
    }

    public String getFaculty() {
        return faculty;
    }

}
