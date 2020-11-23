package com.isa56.exemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public TextView text;
    public TextView age;
    public EditText username;
    public String name;
    public Button button;
    public Spinner spinner;
    public Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        username = findViewById(R.id.name);
        button = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);
        age = findViewById(R.id.age);
        button2 = findViewById(R.id.button2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                MainActivity.this,
                R.array.idades,
                android.R.layout.simple_spinner_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String idade = (String) parent.getItemAtPosition(position);

                if (position == 0) {
                    button2.setEnabled(false);
                    button.setEnabled(false);
                }   else {
                    Toast.makeText(MainActivity.this, "Você selecionou: " + idade, Toast.LENGTH_SHORT).show();
                    age.setText(idade);
                    button.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                age.setText("Selecione uma idade válida");
            }
        });

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String a = spinner.getSelectedItem().toString();
                age.setText(a);
                name = username.getText().toString();
                text.setText("Olá, " + name);
                button2.setEnabled(true);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
//                if (spinner)
                String a = spinner.getSelectedItem().toString();
                i.putExtra("idade", a);
                i.putExtra("usuario", name);
                startActivity(i);
            }
        });

    }
}