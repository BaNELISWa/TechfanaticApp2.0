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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<LectureClass> list;

    public MyAdapter(Context context, ArrayList<LectureClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_post, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        LectureClass lectureClass = list.get(position);
        holder.txtJobView.setText(lectureClass.getJobName());
        holder.txtFacultyView.setText(lectureClass.getFaculty());
        holder.txtDescrView.setText(lectureClass.getDescr());
        holder.txtSalaryView.setText(lectureClass.getSalary());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Job", list.get(holder.getAbsoluteAdapterPosition()).getJobName());
                intent.putExtra("Faculty", list.get(holder.getAbsoluteAdapterPosition()).getFaculty());
                intent.putExtra("Description", list.get(holder.getAbsoluteAdapterPosition()).getDescr());
                intent.putExtra("Salary", list.get(holder.getAbsoluteAdapterPosition()).getSalary());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtJobView, txtFacultyView, txtDescrView, txtSalaryView;

        CardView recCard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            recCard = itemView.findViewById(R.id.recCard);
            txtJobView = itemView.findViewById(R.id.txtJobView);
            txtFacultyView = itemView.findViewById(R.id.txtFacultyView);
            txtDescrView = itemView.findViewById(R.id.txtDescrView);
            txtSalaryView = itemView.findViewById(R.id.txtSalaryView);
        }
    }
}





