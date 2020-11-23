package com.meteoro.recyclerandnotificationexample;

import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    private CardView itemCard;
    private TextView itemName;
    private ConstraintLayout itemConstraint;

    ItemViewHolder(View itemView) {
        super(itemView);
        itemName = itemView.findViewById(R.id.item_name);
        itemCard = itemView.findViewById(R.id.card_item);
        itemConstraint = itemView.findViewById(R.id.item_constraint);
    }

    public void bind(String name, ItemClickListener listener) {
        itemName.setText(name);

        itemConstraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(name);
            }
        });
    }
}
