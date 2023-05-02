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

public class LecturerActivity extends AppCompatActivity {

    TextView txtView;

    private EditText edtJobName, edtDescription, edtSalary, edtFaculty;

    DatabaseReference databaseReference;

    Button btnPost;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer);


        btnPost = findViewById(R.id.btnPost);
        edtJobName = findViewById(R.id.edtJobName);
        edtDescription = findViewById(R.id.edtDescription);
        edtSalary = findViewById(R.id.edtSalary);
        edtFaculty = findViewById(R.id.edtFaculty);
        txtView = findViewById(R.id.txtView);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity((new Intent(LecturerActivity.this, ApplicationRecycler.class)));
            }
        });

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadData();
                startActivity(new Intent(LecturerActivity.this, ApplicantActivity.class));
                finish();
            }
        });

    }

    private void uploadData(){

        String JobName = edtJobName.getText().toString();
        String Descr = edtDescription.getText().toString();
        String Salary = edtSalary.getText().toString();
        String Faculty = edtFaculty.getText().toString();
        String id = databaseReference.push().getKey();

        LectureClass lectureClass = new LectureClass(JobName, Descr, Salary, Faculty);
        databaseReference.child("Lecture Job Database").child(id).setValue(lectureClass)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(LecturerActivity.this, "Data has been uploaded", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }

}