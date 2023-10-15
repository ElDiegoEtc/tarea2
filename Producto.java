package com.example;

abstract class Producto {
    private int serie;
    private PrecioProducto precioProducto;

    public Producto(int serie, PrecioProducto precioProducto) {
        this.serie = serie;
        this.precioProducto = precioProducto;
    }

    public abstract String ingerir();

    public int getSerie() {
        return serie;
    }

    public PrecioProducto getPrecioProducto() {
        return precioProducto;
    }
}