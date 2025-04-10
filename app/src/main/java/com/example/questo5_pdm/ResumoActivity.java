package com.example.questo5_pdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ResumoActivity extends AppCompatActivity {

    private TextView tvSabores, tvTamanho, tvPagamento, tvValorTotal;
    private Button btnNovoPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);


        tvSabores = findViewById(R.id.tvSabores);
        tvTamanho = findViewById(R.id.tvTamanho);
        tvPagamento = findViewById(R.id.tvPagamento);
        tvValorTotal = findViewById(R.id.tvValorTotal);
        btnNovoPedido = findViewById(R.id.btnNovoPedido);


        ArrayList<String> sabores = getIntent().getStringArrayListExtra("sabores");
        String tamanho = getIntent().getStringExtra("tamanho");
        String pagamento = getIntent().getStringExtra("pagamento");
        double valorTotal = getIntent().getDoubleExtra("valorTotal", 0.0);


        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));


        StringBuilder saboresStr = new StringBuilder();
        for (int i = 0; i < sabores.size(); i++) {
            saboresStr.append(sabores.get(i));
            if (i < sabores.size() - 1) {
                saboresStr.append(", ");
            }
        }


        tvSabores.setText("Sabores: " + saboresStr.toString());
        tvTamanho.setText("Tamanho: " + tamanho);
        tvPagamento.setText("Pagamento: " + pagamento);
        tvValorTotal.setText("Valor Total: " + formatoMoeda.format(valorTotal));


        btnNovoPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ResumoActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
}