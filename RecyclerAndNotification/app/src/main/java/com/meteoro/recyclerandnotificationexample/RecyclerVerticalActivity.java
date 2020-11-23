package com.meteoro.recyclerandnotificationexample;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerVerticalActivity extends AppCompatActivity implements ItemClickListener {

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

        adapter = new AdapterLinear(criarNomes(), RecyclerVerticalActivity.this);
        recyclerVertical.setAdapter(adapter);
    }

    @Override
    public void onItemClick(String name) {
        Toast.makeText(RecyclerVerticalActivity.this, name, Toast.LENGTH_SHORT).show();
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
