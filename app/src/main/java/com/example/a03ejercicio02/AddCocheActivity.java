package com.example.a03ejercicio02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a03ejercicio02.modelos.Coche;

public class AddCocheActivity extends AppCompatActivity {
    //Variables de Vista
    private EditText txtModelo;
    private EditText txtMarca;
    private EditText txtColor;
    private Button btnCrear;
    private Button btnCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_coche);

        inicializarVista();

        inicializarEventos();


    }

    private void inicializarEventos() {
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Coche coche = new Coche(
                        txtMarca.getText().toString(),
                        txtModelo.getText().toString(),
                        txtColor.getText().toString()
                );

                Bundle bundle = new Bundle();
                bundle.putSerializable("COCHE", coche);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });
    }



    private void inicializarVista() {
        txtModelo = findViewById(R.id.txtModeloCoche);
        txtMarca = findViewById(R.id.txtMarcaCoche);
        txtColor = findViewById(R.id.txtColorCoche);
        btnCancelar = findViewById(R.id.btnCancelarCoche);
        btnCrear = findViewById(R.id.btnCrearCoche);
    }
}