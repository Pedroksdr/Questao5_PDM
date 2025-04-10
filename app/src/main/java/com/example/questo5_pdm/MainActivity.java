package com.example.questo5_pdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CheckBox chkCalabresa, chkMarguerita, chkPortuguesa, chkFrango, chkQuatroQueijos;
    private Button btnProximo;
    private ArrayList<String> selecionados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkCalabresa = findViewById(R.id.chkCalabresa);
        chkMarguerita = findViewById(R.id.chkMarguerita);
        chkPortuguesa = findViewById(R.id.chkPortuguesa);
        chkFrango = findViewById(R.id.chkFrango);
        chkQuatroQueijos = findViewById(R.id.chkQuatroQueijos);
        btnProximo = findViewById(R.id.btnProximo);


        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selecionados.clear();


                if (chkCalabresa.isChecked()) {
                    selecionados.add("Calabresa");
                }
                if (chkMarguerita.isChecked()) {
                    selecionados.add("Marguerita");
                }
                if (chkPortuguesa.isChecked()) {
                    selecionados.add("Portuguesa");
                }
                if (chkFrango.isChecked()) {
                    selecionados.add("Frango com Catupiry");
                }
                if (chkQuatroQueijos.isChecked()) {
                    selecionados.add("Quatro Queijos");
                }


                if (selecionados.size() > 0) {

                    Intent intent = new Intent(MainActivity.this, TamanhoActivity.class);
                    intent.putStringArrayListExtra("sabores", selecionados);
                    startActivity(intent);
                } else {

                    Toast.makeText(MainActivity.this, "Selecione pelo menos um sabor de pizza!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}