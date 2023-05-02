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

public class MyResponse extends RecyclerView.Adapter<MyResponse.MyViewHolder>{

    Context context;

    ArrayList<StudentClass> list;

    public MyResponse(Context context, ArrayList<StudentClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyResponse.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.student_post, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyResponse.MyViewHolder holder, int position) {
        StudentClass studentClass = list.get(position);
        holder.StudentNum.setText(studentClass.getStudent_number());
        holder.Qualification.setText(studentClass.getQualification());
        holder.Experience.setText(studentClass.getExperience());

        holder.recStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StudentDetailed.class);
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

        TextView StudentNum, Qualification, Experience, Response, Date, Time, Venue;

        CardView recStudent;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            StudentNum = itemView.findViewById(R.id.txtStudentNumView);
            Qualification= itemView.findViewById(R.id.txtQualificationView);
            Experience  = itemView.findViewById(R.id.txtExperienceView);
            recStudent = itemView.findViewById(R.id.reStudent);
        }
    }
}
