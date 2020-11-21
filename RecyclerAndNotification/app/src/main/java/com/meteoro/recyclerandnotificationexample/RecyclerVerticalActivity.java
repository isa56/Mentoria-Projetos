package com.meteoro.recyclerandnotificationexample;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerVerticalActivity extends AppCompatActivity {

    private RecyclerView recyclerVertical;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_vertical);

        recyclerVertical = findViewById(R.id.recycler_vertical);

        layoutManager = new LinearLayoutManager(RecyclerVerticalActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerVertical.setLayoutManager(layoutManager);

        adapter = new AdapterLinear(criarNomes());
        recyclerVertical.setAdapter(adapter);
    }

    private List<String> criarNomes() {
        List<String> nomes = new ArrayList<String>();

        for (int i = 1; i <= 50; i++) {
            String nome = "Nome " + i;
            nomes.add(nome);
        }

        return nomes;
    }
}
