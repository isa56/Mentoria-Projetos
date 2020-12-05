package com.isa56.exemplo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    private TextView texto1;
    private TextView texto2;
    private ConstraintLayout card;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);

        texto1 = itemView.findViewById(R.id.texto1);
        texto2 = itemView.findViewById(R.id.texto2);
        card = itemView.findViewById(R.id.card2);

    }

    public void setName(String name) {
        texto1.setText(name);
    }

    public void bind(Pessoa pessoa, ItemClickListener listener) {
        texto1.setText(pessoa.getNome());
        texto2.setText(pessoa.getSobrenome());

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(pessoa);
            }
        });
    }
}