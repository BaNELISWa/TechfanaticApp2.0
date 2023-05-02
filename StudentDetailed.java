package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class StudentDetailed extends AppCompatActivity {

    TextView Student_Number, Qualification, Experience, Date, Time, Venue, Response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detailed);

        Student_Number = findViewById(R.id.txtStudentNumberDetail2);
        Qualification = findViewById(R.id.txtQualficationDetail2);
        Experience = findViewById(R.id.txtExprienceDetail2);

        Response = findViewById(R.id.Response);
        Date = findViewById(R.id.txtDate);
        Time = findViewById(R.id.txtTime);
        Venue = findViewById(R.id.txtVenue);

        Response.setText(getIntent().getExtras().getString("Response"));
        Date.setText(getIntent().getExtras().getString("Date"));
        Time.setText(getIntent().getExtras().getString("Time"));
        Venue.setText(getIntent().getExtras().getString("Venue"));


        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            Student_Number.setText(bundle.getString("Student Number"));
            Qualification.setText(bundle.getString("Qualification"));
            Experience.setText(bundle.getString("Experience"));
        }
    }
}