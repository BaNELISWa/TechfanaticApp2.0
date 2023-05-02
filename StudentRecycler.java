package com.example.mobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StudentRecycler extends AppCompatActivity {

    RecyclerView studentRecycler;

    ArrayList<StudentClass> studentList;

    ArrayList<AccountClass> accountList;

    DatabaseReference databaseReference;

    MyResponse myResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_recycler);

        studentRecycler = findViewById(R.id.studentRecycler);


        databaseReference = FirebaseDatabase.getInstance().getReference("Student Application");
        studentList = new ArrayList<>();
        studentRecycler.setLayoutManager(new LinearLayoutManager(this));
        myResponse = new MyResponse(this, studentList);
        studentRecycler.setAdapter(myResponse);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    StudentClass studentClass = dataSnapshot.getValue(StudentClass.class);
                    studentList.add(studentClass);
                }
                myResponse.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}