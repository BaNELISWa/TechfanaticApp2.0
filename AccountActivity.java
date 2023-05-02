package com.example.mobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AccountActivity extends AppCompatActivity {
    private static final String TAG = "AccountActivity";

    String email, password, Username, Email, Password, Type, id;

    FirebaseAuth mAuth;

    DatabaseReference databaseReference;
    private EditText edtName2, edtEmail2, edtPassword2, edtConfirm;
    private Button btnSignIn;
    private TextView txtName2, txtEmail2, txtPassword2, txtConfirm;
    private RadioGroup rgType2;
    private ConstraintLayout parent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        mAuth = FirebaseAuth.getInstance();
        edtName2 = findViewById(R.id.edtName2);
        edtEmail2 = findViewById(R.id.edtEmail2);
        edtPassword2 = findViewById(R.id.edtPassword2);
        edtConfirm = findViewById(R.id.edtConfirm);

        btnSignIn = findViewById(R.id.btnSignIn);

        txtName2 = findViewById(R.id.txtName2);
        txtEmail2 = findViewById(R.id.txtEmail2);
        txtPassword2 = findViewById(R.id.txtPassword2);
        txtConfirm = findViewById(R.id.txtConfirm);

        rgType2 = findViewById(R.id.rgType2);
        parent2 = findViewById(R.id.parent2);

        databaseReference = FirebaseDatabase.getInstance().getReference();



        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initRegister();
                validateData();


            }
        });


    }

    private void initRegister(){
        Log.d(TAG, "initRegister: Started");

        if (validateData()){
            switch (rgType2.getCheckedRadioButtonId()){
                case R.id.rbStudent2:
                    Username = edtName2.getText().toString();
                    Email = edtEmail2.getText().toString();
                    Type = "Student";
                    id = databaseReference.push().getKey();

                    AccountClass accountClass = new AccountClass(Username, Email, Password, Type);
                    databaseReference.child("Account").child(id).setValue(accountClass)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(AccountActivity.this, "Information saved", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                    Intent lecture = new Intent(AccountActivity.this, StudentActivity.class);
                    startActivity(lecture);
                    break;
                case R.id.rbLecturer2:
                    Username = edtName2.getText().toString();
                    Email = edtEmail2.getText().toString();
                    Type = "Lecture";
                    id = databaseReference.push().getKey();

                    AccountClass accountClass2 = new AccountClass(Username, Email, Password, Type);
                    databaseReference.child("Account").child(id).setValue(accountClass2)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(AccountActivity.this, "Information saved", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                    Intent student = new Intent(AccountActivity.this, LecturerActivity.class);
                    startActivity(student);
                    break;
                default:
                    break;
            }
        }else{
            showSnackBar();
        }
    }

    private void showSnackBar(){
        Log.d(TAG, "showSnackBar: Started");
        txtName2.setVisibility(View.GONE);
        txtEmail2.setVisibility(View.GONE);
        txtPassword2.setVisibility(View.GONE);
        txtConfirm.setVisibility(View.GONE);


        Snackbar.make(parent2, "Something went wrong", Snackbar.LENGTH_INDEFINITE).setAction("Dismiss", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtName2.setText("");
                edtEmail2.setText("");
                edtPassword2.setText("");
                edtConfirm.setText("");
            }
        }).show();
    }

    private  boolean validateData(){
        Log.d(TAG, "validateData: started");

        if (edtName2.getText().toString().equals("")){
            txtName2.setVisibility(View.VISIBLE);
            txtName2.setText("Enter your username");
            return  false;
        }

        if (edtEmail2.getText().toString().equals("")){
            txtEmail2.setVisibility(View.VISIBLE);
            txtEmail2.setText("Enter your email address");
            return  false;
        }

        if (edtPassword2.getText().toString().equals("")){
            txtPassword2.setVisibility(View.VISIBLE);
            txtPassword2.setText("Enter your password");
            return  false;
        }

        if (edtConfirm.getText().toString().equals("")){
            txtConfirm.setVisibility(View.VISIBLE);
            txtConfirm.setText("Re-enter your password");
            return  false;
        }

        if (!edtPassword2.getText().toString().equals(edtConfirm.getText().toString())){
            txtConfirm.setVisibility(View.VISIBLE);
            txtConfirm.setText("Password doesn't match");
            return false;
        }


        return true;
    }


}