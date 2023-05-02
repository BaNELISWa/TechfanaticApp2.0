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

public class AdminRecycler extends AppCompatActivity {

    RecyclerView recyclerView2;
    ArrayList<LectureClass> list;

    ArrayList<AccountClass> accountList;
    DatabaseReference databaseReference, database;
    MyAdmin myAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_recycler);

        recyclerView2 = findViewById(R.id.recyclerView2);

        database = FirebaseDatabase.getInstance().getReference("Account");
        databaseReference = FirebaseDatabase.getInstance().getReference("Lecture Job Database");
        list = new ArrayList<>();
        accountList = new ArrayList<>();
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        myAdmin = new MyAdmin(this, list, accountList);
        recyclerView2.setAdapter(myAdmin);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    AccountClass accountClass = dataSnapshot.getValue(AccountClass.class);
                    accountList.add(accountClass);
                }
                myAdmin.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    LectureClass lectureClass = dataSnapshot.getValue(LectureClass.class);
                    list.add(lectureClass);
                }
                myAdmin.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}