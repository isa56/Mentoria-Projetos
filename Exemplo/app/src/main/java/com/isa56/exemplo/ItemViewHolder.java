package com.isa56.exemplo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    private TextView texto;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);

        texto = itemView.findViewById(R.id.texto);
    }

    public void setName(String name) {
        texto.setText(name);
    }
}
