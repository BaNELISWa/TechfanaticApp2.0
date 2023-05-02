package com.example.mobileapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyApplicant extends RecyclerView.Adapter<MyApplicant.MyViewHolder> {

    Context context;
    ArrayList<LectureClass> list;

    public MyApplicant(Context context, ArrayList<LectureClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyApplicant.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_post, parent, false);
        return new MyApplicant.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyApplicant.MyViewHolder holder, int position) {
        LectureClass lectureClass = list.get(position);
        holder.txtJobView.setText(lectureClass.getJobName());
        holder.txtFacultyView.setText(lectureClass.getFaculty());
        holder.txtDescrView.setText(lectureClass.getDescr());
        holder.txtSalaryView.setText(lectureClass.getSalary());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtJobView, txtFacultyView, txtDescrView, txtSalaryView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtJobView = itemView.findViewById(R.id.txtJobView);
            txtFacultyView = itemView.findViewById(R.id.txtFacultyView);
            txtDescrView = itemView.findViewById(R.id.txtDescrView);
            txtSalaryView = itemView.findViewById(R.id.txtSalaryView);
        }
    }
}
