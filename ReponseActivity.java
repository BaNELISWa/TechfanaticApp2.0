package com.example.mobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ReponseActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView responseRecycler;
    ArrayList<StudentClass> list;
    DatabaseReference database;
    MyResponse myResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reponse);

        responseRecycler = findViewById(R.id.responseRecycler);
        fab = findViewById(R.id.response_fab);

        ///Gathers data from the firebase database, under the path Student Application, which contains details of the student
        database = FirebaseDatabase.getInstance().getReference("Student Application");
        ///The data gathered from the firebase is stored in an Array, where the components can collect the data from the Array
        list = new ArrayList<>();
        responseRecycler.setLayoutManager(new LinearLayoutManager(this));
        myResponse = new MyResponse(this, list);
        responseRecycler.setAdapter(myResponse);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    StudentClass studentClass = dataSnapshot.getValue(StudentClass.class);
                    list.add(studentClass);
                }
                myResponse.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReponseActivity.this, StudentActivity.class);
                startActivity(intent);
            }
        });

    }
}