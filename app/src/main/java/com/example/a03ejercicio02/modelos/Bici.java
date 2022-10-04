package com.example.a03ejercicio02.modelos;

import java.io.Serializable;

public class Bici implements Serializable {
    private String marca;
    private int pulgadas;

    public Bici(String marca, int pulgadas) {
        this.marca = marca;
        this.pulgadas = pulgadas;
    }

}
