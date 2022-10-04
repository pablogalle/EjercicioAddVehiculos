package com.example.a03ejercicio02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a03ejercicio02.modelos.Bici;
import com.example.a03ejercicio02.modelos.Moto;

public class AddMotoActivity extends AppCompatActivity {
    //Variables de Vista
    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtCc;
    private Button btnCrear;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_moto);

        inicializarVista();

        inicializarEventos();
    }

    private void inicializarEventos() {
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Moto moto = new Moto(
                        txtMarca.getText().toString(),
                        txtModelo.getText().toString(),
                        Integer.parseInt(txtCc.getText().toString())
                );

                Bundle bundle = new Bundle();
                bundle.putSerializable("MOTO", moto);
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
        txtMarca = findViewById(R.id.txtMarcaMoto);
        txtModelo = findViewById(R.id.txtModeloMoto);
        txtCc = findViewById(R.id.txtCcMoto);
        btnCancelar = findViewById(R.id.btnCancelarMoto);
        btnCrear = findViewById(R.id.btnCrearMoto);
    }
}