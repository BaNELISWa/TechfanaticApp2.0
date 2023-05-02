package com.example.mobileapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MyStudent extends RecyclerView.Adapter<MyStudent.MyViewHolder>{

    Context context;

    ArrayList<StudentClass> list;

    ArrayList<AccountClass> accountList;

    public MyStudent(Context context, ArrayList<StudentClass> list, ArrayList<AccountClass> accountList) {
        this.context = context;
        this.list = list;
        this.accountList = accountList;
    }


    @NonNull
    @Override
    public MyStudent.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.student_post, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyStudent.MyViewHolder holder, int position) {
        ///Components collecting or using data received from the Array
        StudentClass studentClass = list.get(position);
        holder.StudentNum.setText(studentClass.getStudent_number());
        holder.Qualification.setText(studentClass.getQualification());

        holder.recStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///Data is transferred to an activity
                Intent intent = new Intent(context, ApplicationDetailed.class);
                intent.putExtra("Student Number", list.get(holder.getAbsoluteAdapterPosition()).getStudent_number());
                intent.putExtra("Qualification", list.get(holder.getAbsoluteAdapterPosition()).getQualification());
                intent.putExtra("Experience", list.get(holder.getAbsoluteAdapterPosition()).getExperience());


                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Username, StudentNum, Qualification, Experience, Response, Date, Time, Venue;
        CardView recStudent;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            StudentNum = itemView.findViewById(R.id.txtStudentNumView);
            Qualification= itemView.findViewById(R.id.txtQualificationView);
            Experience = itemView.findViewById(R.id.txtExperienceView);
            recStudent = itemView.findViewById(R.id.reStudent);
        }
    }
}
