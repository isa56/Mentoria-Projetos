package com.isa56.exemplo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recycler = findViewById(R.id.recycler);

        layoutManager = new LinearLayoutManager(SecondActivity.this, LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);

        adapter = new AdapterLinear(nomesPraRecycler());
        recycler.setAdapter(adapter);
    }

    private List<String> nomesPraRecycler(){
        List<String> nomes = new ArrayList<String>();

        for (int i = 0; i <= 50; i++){
            String nome = "Nome " + i;
            nomes.add(nome);
        }

        return nomes;

    }
}
