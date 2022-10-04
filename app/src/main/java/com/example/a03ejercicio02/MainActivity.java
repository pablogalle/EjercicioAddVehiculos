package com.example.a03ejercicio02;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a03ejercicio02.modelos.Bici;
import com.example.a03ejercicio02.modelos.Coche;
import com.example.a03ejercicio02.modelos.Moto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Variables Vista
    private Button btnAddCoche;
    private TextView lblNumCoches;
    private Button btnAddMoto;
    private TextView lblNumMotos;
    private Button btnAddBici;
    private TextView lblNumBici;

    //ActivityResultLaunchers
    private ActivityResultLauncher<Intent> addCocheLauncher;
    private ActivityResultLauncher<Intent> addMotoLauncher;
    private ActivityResultLauncher<Intent> addBiciLauncher;
    //Variables Logicas
    ArrayList<Coche> coches = new ArrayList<>();
    ArrayList<Moto> motos = new ArrayList<>();
    ArrayList<Bici> bicis = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVista();

        inicializarEventos();

        inicializaActivityResultLaunchers();
    }

    private void inicializaActivityResultLaunchers() {
        addCocheLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            if (result.getData() != null) {
                                Coche coche = (Coche) result.getData().getExtras().getSerializable("COCHE");
                                coches.add(coche);
                                Toast.makeText(MainActivity.this, "Coche guardado correctamente", Toast.LENGTH_SHORT).show();
                            }
                        } else
                            Toast.makeText(MainActivity.this, "CANCELADO", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        addMotoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            if (result.getData() != null) {
                                Moto moto = (Moto) result.getData().getExtras().getSerializable("MOTO");
                                motos.add(moto);
                                Toast.makeText(MainActivity.this, "Moto guardada correctamente", Toast.LENGTH_SHORT).show();
                            }
                        } else
                            Toast.makeText(MainActivity.this, "CANCELADO", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        addBiciLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            if (result.getData() != null) {
                                Bici bici = (Bici) result.getData().getExtras().getSerializable("BICI");
                                bicis.add(bici);
                                Toast.makeText(MainActivity.this, "Bici guardada correctamente", Toast.LENGTH_SHORT).show();
                            }
                        } else
                            Toast.makeText(MainActivity.this, "CANCELADO", Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }

    private void inicializarEventos() {
        btnAddCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddCocheActivity.class);
                addCocheLauncher.launch(intent);
            }
        });
        btnAddMoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddMotoActivity.class);
                addMotoLauncher.launch(intent);
            }
        });
        btnAddBici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddBiciActivity.class);
                addBiciLauncher.launch(intent);
            }
        });

    }

    private void actualizaVista() {
        lblNumCoches.setText(""+coches.size());
        lblNumMotos.setText(""+motos.size());
        lblNumBici.setText(""+bicis.size());
    }

    private void inicializarVista() {
        btnAddCoche = findViewById(R.id.btnAddCocheMain);
        btnAddMoto = findViewById(R.id.btnAddMotoMain);
        btnAddBici = findViewById(R.id.btnAddBiciMain);
        lblNumCoches = findViewById(R.id.lblNumCochesMain);
        lblNumMotos = findViewById(R.id.lblNumMotosMain);
        lblNumBici = findViewById(R.id.lblNumBicisMain);

    }

    @Override
    protected void onResume() {
        actualizaVista();
        super.onResume();
    }
}