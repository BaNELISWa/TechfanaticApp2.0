package com.example.mobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminDetailed extends AppCompatActivity {

    TextView txtUserDetailed2, txtFacultyDetailed2, txtJobDetailed2;
    private RadioGroup rgbType;
    private RadioButton rbIT, rbBusiness, rbHospitality, rbEngineering, rbAnimal;
    String UserDetailed, JobDetailed, FacultyDetailed, Type, id;

    AdminClass adminClass;
    DatabaseReference databaseReference;

    Button btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_detailed);

        rgbType = findViewById(R.id.rgbType);
        txtUserDetailed2 = findViewById(R.id.txtUserDetailed2);
        txtJobDetailed2 = findViewById(R.id.txtJobDetailed2);
        txtFacultyDetailed2 = findViewById(R.id.txtFacultyDetailed2);
        btnAdd = findViewById(R.id.btnAdd);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        Bundle bundle = getIntent().getExtras();
        if (bundle!= null){
            txtUserDetailed2.setText(bundle.getString("Username"));
            txtJobDetailed2.setText(bundle.getString("Job"));
            txtFacultyDetailed2.setText(bundle.getString("Faculty"));
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rgbType.getCheckedRadioButtonId()){
                    case R.id.rbIT:
                        UserDetailed = txtUserDetailed2.getText().toString();
                        JobDetailed = txtJobDetailed2.getText().toString();
                        FacultyDetailed = txtFacultyDetailed2.getText().toString();
                        Type = "Information Technology";
                        id = databaseReference.push().getKey();

                        adminClass = new AdminClass(UserDetailed, JobDetailed, FacultyDetailed, Type);
                        databaseReference.child("Admin Database").child(id).setValue(adminClass)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()){
                                            Toast.makeText(AdminDetailed.this, "Information has been saved on the database", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                        break;
                    case R.id.rbAnimal:
                        UserDetailed = txtUserDetailed2.getText().toString();
                        JobDetailed = txtJobDetailed2.getText().toString();
                        FacultyDetailed = txtFacultyDetailed2.getText().toString();
                        Type = "Animal Science";
                        id = databaseReference.push().getKey();

                        adminClass = new AdminClass(UserDetailed, JobDetailed, FacultyDetailed, Type);
                        databaseReference.child("Admin Database").child(id).setValue(adminClass)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()){
                                            Toast.makeText(AdminDetailed.this, "Information has been saved on the database", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                        break;
                    case R.id.rbBusiness:
                        UserDetailed = txtUserDetailed2.getText().toString();
                        JobDetailed = txtJobDetailed2.getText().toString();
                        FacultyDetailed = txtFacultyDetailed2.getText().toString();
                        Type = "Business";
                        id = databaseReference.push().getKey();

                        adminClass = new AdminClass(UserDetailed, JobDetailed, FacultyDetailed, Type);
                        databaseReference.child("Admin Database").child(id).setValue(adminClass)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()){
                                            Toast.makeText(AdminDetailed.this, "Information has been saved on the database", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                        break;
                    case R.id.rbHospitality:
                        UserDetailed = txtUserDetailed2.getText().toString();
                        JobDetailed = txtJobDetailed2.getText().toString();
                        FacultyDetailed = txtFacultyDetailed2.getText().toString();
                        Type = "Hospitality";
                        id = databaseReference.push().getKey();

                        adminClass = new AdminClass(UserDetailed, JobDetailed, FacultyDetailed, Type);
                        databaseReference.child("Admin Database").child(id).setValue(adminClass)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()){
                                            Toast.makeText(AdminDetailed.this, "Information has been saved on the database", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                        break;
                    case R.id.rbEngineering:
                        UserDetailed = txtUserDetailed2.getText().toString();
                        JobDetailed = txtJobDetailed2.getText().toString();
                        FacultyDetailed = txtFacultyDetailed2.getText().toString();
                        Type = "Engineering";
                        id = databaseReference.push().getKey();

                        adminClass = new AdminClass(UserDetailed, JobDetailed, FacultyDetailed, Type);
                        databaseReference.child("Admin Database").child(id).setValue(adminClass)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()){
                                            Toast.makeText(AdminDetailed.this, "Information has been saved on the database", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                        break;
                }
            }
        });



    }
}