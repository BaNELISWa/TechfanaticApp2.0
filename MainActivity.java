package com.example.mobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    EditText edtEmail, edtPassword;

    AccountClass accountClass;

    Button btnLogIn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.email);
        edtPassword = findViewById(R.id.password);
        btnLogIn = findViewById(R.id.btnLogIn);
        TextView txtCreate = findViewById(R.id.txtCreate);


        txtCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent account = new Intent(MainActivity.this, AccountActivity.class);
                startActivity(account);
            }
        });

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtEmail.getText().toString().equals("khethelo@gmail.com") && edtPassword.getText().toString().equals("helloWorld")){
                    Intent admin = new Intent(MainActivity.this, AdminRecycler.class);
                    startActivity(admin);
                }

                if (edtEmail.getText().toString().equals("Lulu@gmail.com") && edtPassword.getText().toString().equals("hello123")){
                    Intent admin = new Intent(MainActivity.this, LecturerActivity.class);
                    startActivity(admin);
                }

                if (edtEmail.getText().toString().equals("Ndabe@gmail.com") && edtPassword.getText().toString().equals("hello246")){
                    Intent admin = new Intent(MainActivity.this, ReponseActivity.class);
                    startActivity(admin);
                }


            }
        });

    }
}