package com.example.mobileapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAccount extends RecyclerView.Adapter<MyAccount.MyViewHolder> {

    Context context;

    ArrayList<AccountClass> accountList;

    @NonNull
    @Override
    public MyAccount.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAccount.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return accountList.size();
    }

    public void searchList(ArrayList<AccountClass> searchList){
        accountList = searchList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
