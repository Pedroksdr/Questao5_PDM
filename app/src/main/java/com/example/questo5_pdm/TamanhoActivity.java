package com.example.questo5_pdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TamanhoActivity extends AppCompatActivity {

    private RadioGroup rgTamanho, rgPagamento;
    private RadioButton rbPequena, rbMedia, rbGrande;
    private RadioButton rbDinheiro, rbCartao, rbPix;
    private Button btnContinuar;
    private ArrayList<String> sabores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamanho);


        sabores = getIntent().getStringArrayListExtra("sabores");


        rgTamanho = findViewById(R.id.rgTamanho);
        rgPagamento = findViewById(R.id.rgPagamento);

        rbPequena = findViewById(R.id.rbPequena);
        rbMedia = findViewById(R.id.rbMedia);
        rbGrande = findViewById(R.id.rbGrande);

        rbDinheiro = findViewById(R.id.rbDinheiro);
        rbCartao = findViewById(R.id.rbCartao);
        rbPix = findViewById(R.id.rbPix);

        btnContinuar = findViewById(R.id.btnContinuar);


        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (rgTamanho.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(TamanhoActivity.this, "Selecione o tamanho da pizza!", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (rgPagamento.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(TamanhoActivity.this, "Selecione o método de pagamento!", Toast.LENGTH_SHORT).show();
                    return;
                }


                String tamanho = "";
                double valorBase = 0.0;

                if (rbPequena.isChecked()) {
                    tamanho = "Pequena";
                    valorBase = 25.0;
                } else if (rbMedia.isChecked()) {
                    tamanho = "Média";
                    valorBase = 35.0;
                } else if (rbGrande.isChecked()) {
                    tamanho = "Grande";
                    valorBase = 45.0;
                }


                String pagamento = "";
                if (rbDinheiro.isChecked()) {
                    pagamento = "Dinheiro";
                } else if (rbCartao.isChecked()) {
                    pagamento = "Cartão";
                } else if (rbPix.isChecked()) {
                    pagamento = "PIX";
                }


                double valorTotal = valorBase;
                if (sabores.size() > 1) {
                    valorTotal += (sabores.size() - 1) * 3.0;
                }


                Intent intent = new Intent(TamanhoActivity.this, ResumoActivity.class);
                intent.putStringArrayListExtra("sabores", sabores);
                intent.putExtra("tamanho", tamanho);
                intent.putExtra("pagamento", pagamento);
                intent.putExtra("valorTotal", valorTotal);
                startActivity(intent);
            }
        });
    }
}