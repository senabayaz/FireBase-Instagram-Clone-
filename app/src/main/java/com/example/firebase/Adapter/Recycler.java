package com.example.firebase.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebase.Model.Posts;
import com.example.firebase.databinding.RecyclerRowBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Recycler extends RecyclerView.Adapter<Recycler.holder> {
    ArrayList<Posts> arrayList;

    public Recycler(ArrayList<Posts> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new holder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.recyclerRowBinding.txt.setText(arrayList.get(position).email);
        holder.recyclerRowBinding.txt2.setText(arrayList.get(position).commant);
        Picasso.get().load(arrayList.get(position).image).into(holder.recyclerRowBinding.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class holder extends RecyclerView.ViewHolder{
        RecyclerRowBinding recyclerRowBinding;
        public holder(RecyclerRowBinding recyclerRowBinding) {
            super(recyclerRowBinding.getRoot());
            this.recyclerRowBinding = recyclerRowBinding;
        }
    }
}
