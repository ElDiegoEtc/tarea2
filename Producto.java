package com.example;

abstract class Producto {
    private int serie;
    public Producto(int serie){
        this.serie = serie;
    }
    public abstract String ingerir();

    public int getSerie() {
        return serie;
    }
}
