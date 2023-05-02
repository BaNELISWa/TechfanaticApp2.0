package com.example.mobileapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdmin extends RecyclerView.Adapter<MyAdmin.MyViewHolder2> {

    private Context context;
    private ArrayList<LectureClass> list;

    private ArrayList<AccountClass> accountList;

    public MyAdmin(Context context, ArrayList<LectureClass> list, ArrayList<AccountClass> accountList) {
        this.context = context;
        this.list = list;
        this.accountList = accountList;
    }

    @NonNull
    @Override
    public MyAdmin.MyViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_admin,parent,false);
        return new MyViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdmin.MyViewHolder2 holder, int position) {
        LectureClass lectureClass = list.get(position);
        AccountClass accountClass = accountList.get(position);
        holder.txtUserAdmin.setText(accountClass.getUsername());
        holder.txtJobAdmin.setText(lectureClass.getJobName());
        holder.txtFacultyAdmin.setText(lectureClass.getFaculty());



        holder.reAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent admin_intent = new Intent(context, AdminDetailed.class);
                admin_intent.putExtra("Username", accountList.get(holder.getAbsoluteAdapterPosition()).getUsername());
                admin_intent.putExtra("Job", list.get(holder.getAbsoluteAdapterPosition()).getJobName());
                admin_intent.putExtra("Faculty", list.get(holder.getAbsoluteAdapterPosition()).getFaculty());

                context.startActivity(admin_intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder {

        TextView txtUserAdmin, txtFacultyAdmin, txtJobAdmin;
        CardView reAdmin;
        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);


            reAdmin = itemView.findViewById(R.id.reAdmin);
            txtUserAdmin = itemView.findViewById(R.id.txtUserAdmin);
            txtJobAdmin = itemView.findViewById(R.id.txtJobAdmin);
            txtFacultyAdmin = itemView.findViewById(R.id.txtFacultyAdmin);
        }
    }
}

