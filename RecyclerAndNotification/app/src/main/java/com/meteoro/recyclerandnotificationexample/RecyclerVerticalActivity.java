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

        adapter = new AdapterLinear(criarPessoas(), RecyclerVerticalActivity.this);
        recyclerVertical.setAdapter(adapter);
    }

    @Override
    public void onItemClick(Pessoa pessoa) {
        Toast.makeText(RecyclerVerticalActivity.this, pessoa.getName() + " " + pessoa.getLastName(), Toast.LENGTH_SHORT).show();
        String title = pessoa.getName();
        String content = pessoa.getLastName() + " é um sobrenome de uma familia muito importante...";
        NotificationUtils.notificationSimple(RecyclerVerticalActivity.this, title, content);
    }

    private List<Pessoa> criarPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();

        for (int i = 1; i <= 50; i++) {
            String nome = "Nome " + i;
            String sobrenome = "Sobrenome " + i;
            pessoas.add(new Pessoa(nome, sobrenome));
        }

        return pessoas;
    }
}
