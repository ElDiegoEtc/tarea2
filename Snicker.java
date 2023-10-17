package com.example;

public class Snicker extends Dulce {
    public Snicker(int serie, PrecioProducto precioProducto) {
        super(serie, precioProducto.SNICKER);
    }
    public String ingerir(){
        return "SNICKERS";
    }

}
