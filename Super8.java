package com.example;

public class Super8 extends Dulce {
    public Super8(int serie, PrecioProducto precioProducto) {
        super(serie, precioProducto.SUPER8);
    }

    public String ingerir(){
        return "SUPER8";
    }

}