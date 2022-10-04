package com.example.a03ejercicio02.modelos;

import java.io.Serializable;

public class Moto implements Serializable {
    private String marca;
    private String modelo;
    private int cc;

    public Moto(String marca, String modelo, int cc) {
        this.marca = marca;
        this.modelo = modelo;
        this.cc = cc;
    }

}
