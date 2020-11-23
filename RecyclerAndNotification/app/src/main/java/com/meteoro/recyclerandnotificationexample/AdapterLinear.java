package com.meteoro.recyclerandnotificationexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterLinear extends RecyclerView.Adapter<ItemViewHolder> {

    private List<String> dataSet;
    private ItemClickListener listener;

    AdapterLinear(List<String> data, ItemClickListener dataListener) {
        dataSet = data;
        listener = dataListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_vertical, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        String name = dataSet.get(position);
        holder.bind(name, listener);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
