package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ApplicationDetailed extends AppCompatActivity {

    TextView UserDetail, Student_Number, Qualification, Experience;

    Button btnHire, btnReject;

    EditText date, time, venue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_detailed);
        Student_Number = findViewById(R.id.txtStudentNumberDetail);
        Qualification = findViewById(R.id.txtQualficationDetail);
        Experience = findViewById(R.id.txtExprienceDetail);

        date = findViewById(R.id.edtDate);
        time = findViewById(R.id.edtTime);
        venue = findViewById(R.id.edtVenue);

        btnHire = findViewById(R.id.btnHire);
        btnReject = findViewById(R.id.btnReject);

        String accept = "Accepted";
        String reject = "Rejected";

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            UserDetail.setText(bundle.getString("Username"));
            Student_Number.setText(bundle.getString("Student Number"));
            Qualification.setText(bundle.getString("Qualification"));
            Experience.setText(bundle.getString("Experience"));
        }

        btnHire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ApplicationDetailed.this, StudentDetailed.class);
                intent.putExtra(date.getText().toString(), "Date");
                intent.putExtra(time.getText().toString(), "Time");
                intent.putExtra(venue.getText().toString(), "Venue");
                intent.putExtra(accept, "Response");
            }
        });



    }
}