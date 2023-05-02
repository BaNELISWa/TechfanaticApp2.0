package com.example.mobileapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ApplicationActivity extends AppCompatActivity {

    EditText edtStudentNum, edtQualification, edtExperience;

    TextView Response_View;

    DatabaseReference database;

    Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

        edtStudentNum = findViewById(R.id.edtStudentNum);
        edtQualification = findViewById(R.id.edtQualification);
        edtExperience = findViewById(R.id.edtExperience);
        btnSubmit = findViewById(R.id.btnSubmit);
        Response_View = findViewById(R.id.txtResponseView);
        database = FirebaseDatabase.getInstance().getReference();

        Response_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ApplicationActivity.this, StudentRecycler.class));
                finish();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadData();
                startActivity(new Intent(ApplicationActivity.this, ReponseActivity.class));
                finish();
            }
        });



    }
    private  void uploadData(){

        ///Details collected from the edit text (inputted by the student), being stored in the instances of the Student Class
        String StudentNum = edtStudentNum.getText().toString();
        String Qualification = edtQualification.getText().toString();
        String Experience = edtExperience.getText().toString();
        String id = database.push().getKey(); ///id used to uniquely identify the information of the student

        StudentClass studentClass = new StudentClass(StudentNum, Qualification, Experience);
        database.child("Student Application").child(id).setValue(studentClass)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(ApplicationActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}