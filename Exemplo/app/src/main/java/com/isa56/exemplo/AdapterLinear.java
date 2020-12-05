package com.isa56.exemplo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterLinear extends RecyclerView.Adapter<ItemViewHolder> {

    private List<Pessoa> dataSet;
    private ItemClickListener listener;

    AdapterLinear(List<Pessoa> data, ItemClickListener listener) {
        dataSet = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater i = LayoutInflater.from(parent.getContext());
        View view = i.inflate(R.layout.item_exemplo1, parent, false);

        ItemViewHolder a = new ItemViewHolder(view);
        return a;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(dataSet.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
