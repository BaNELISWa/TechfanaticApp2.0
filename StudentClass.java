package com.example.mobileapp;

import com.google.firebase.database.IgnoreExtraProperties;
//Student Class used to store the details entered by the student
@IgnoreExtraProperties
public class StudentClass {

    private String student_number;
    private String qualification;
    private String experience;

    public  StudentClass(){

    }

    //The constructor will receive instances from the students inputs from the edit text on the application page
    public StudentClass(String student_number, String qualification, String experience) {
        this.student_number = student_number;
        this.qualification = qualification;
        this.experience = experience;
    }

    public String getStudent_number() {
        return student_number;
    }

    public String getQualification() {
        return qualification;
    }

    public String getExperience() {
        return experience;
    }
}
