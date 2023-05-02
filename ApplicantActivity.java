package com.example.mobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ApplicantActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView recyclerView4;
    ArrayList<LectureClass> lectureList;
    DatabaseReference databaseReference;

    MyApplicant myApplicant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicant);

        fab = findViewById(R.id.fab);
        recyclerView4 = findViewById(R.id.recyclerView4);

        databaseReference = FirebaseDatabase.getInstance().getReference("Lecture Job Database");
        lectureList = new ArrayList<>();
        recyclerView4.setLayoutManager(new LinearLayoutManager(this));
        myApplicant = new MyApplicant(this, lectureList);
        recyclerView4.setAdapter(myApplicant);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    LectureClass lectureClass = dataSnapshot.getValue(LectureClass.class);
                    lectureList.add(lectureClass);
                }
                myApplicant.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        fab.setOnClickListener(view -> {
            Intent intent = new Intent(ApplicantActivity.this, LecturerActivity.class);
            startActivity(intent);
        });

    }
}