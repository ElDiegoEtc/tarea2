package com.example;

public class Snicker extends Dulce {
    public Snicker(int serie, PrecioProducto precioProducto) {
        super(serie, precioProducto.SNICKERS);
    }

    public String ingerir(){
        return "SUPER8";
    }

}