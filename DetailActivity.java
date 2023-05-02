package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView txtJobDetail, txtFacultyDetail, txtDescrDetail, txtSalaryDetail;

    Button btnApply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtJobDetail = findViewById(R.id.txtJobDetail);
        txtFacultyDetail = findViewById(R.id.txtFacultyDetail);
        txtDescrDetail = findViewById(R.id.txtDescrDetail);
        txtSalaryDetail = findViewById(R.id.txtSalaryDetail);
        btnApply = findViewById(R.id.btnApp);

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, ApplicationActivity.class);
                startActivity(intent);
            }
        });



        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            txtJobDetail.setText(bundle.getString("Job"));
            txtFacultyDetail.setText(bundle.getString("Faculty"));
            txtDescrDetail.setText(bundle.getString("Description"));
            txtSalaryDetail.setText(bundle.getString("Salary"));
        }

    }
}