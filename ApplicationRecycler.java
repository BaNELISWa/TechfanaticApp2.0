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

public class ApplicationRecycler extends AppCompatActivity {

    RecyclerView appRecycler;
    ArrayList<StudentClass> list;

    ArrayList<AccountClass> accountList;
    DatabaseReference database, databaseReference;
    MyStudent myStudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_recycler);

        appRecycler = findViewById(R.id.applicationRecycler);

        databaseReference = FirebaseDatabase.getInstance().getReference("Account");
        database = FirebaseDatabase.getInstance().getReference("Student Application");
        list = new ArrayList<>();
        accountList = new ArrayList<>();
        appRecycler.setLayoutManager(new LinearLayoutManager(this));
        myStudent = new MyStudent(this, list, accountList);
        appRecycler.setAdapter(myStudent);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    AccountClass accountClass = dataSnapshot.getValue(AccountClass.class);
                    accountList.add(accountClass);
                }
                myStudent.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    StudentClass studentClass = dataSnapshot.getValue(StudentClass.class);
                    list.add(studentClass);
                }
                myStudent.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}