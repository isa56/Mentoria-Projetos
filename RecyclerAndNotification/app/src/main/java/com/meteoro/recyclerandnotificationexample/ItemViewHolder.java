package com.meteoro.recyclerandnotificationexample;

import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    private TextView itemName;
    private TextView itemLastName;
    private ConstraintLayout itemConstraint;

    ItemViewHolder(View itemView) {
        super(itemView);
        itemName = itemView.findViewById(R.id.item_name);
        itemLastName = itemView.findViewById(R.id.last_name);
        itemConstraint = itemView.findViewById(R.id.item_constraint);
    }

    public void bind(Pessoa pessoa, ItemClickListener listener) {
        itemName.setText(pessoa.getName());
        itemLastName.setText(pessoa.getLastName());

        itemConstraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(pessoa);
            }
        });
    }
}
