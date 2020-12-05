package com.isa56.exemplo;

import android.app.Notification;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity implements ItemClickListener {

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

        adapter = new AdapterLinear(criarPessoas(), this);
        recycler.setAdapter(adapter);
    }


    private List<Pessoa> criarPessoas() {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        for (int i = 0; i <= 50; i++) {
            String nome = "Nome " + i;
            String sobrenome = "Sobrenome " + i;
            pessoas.add(new Pessoa(nome, sobrenome));
        }
        return pessoas;
    }

    @Override
    public void onItemClick(Pessoa p) {
        String title = p.getNome();
        String content = p.getSobrenome() + " é um sobrenome";
        NotificationUtils.notificationSimple(SecondActivity.this, title, content);

    }
}
