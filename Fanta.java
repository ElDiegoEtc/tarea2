package com.example;

class Fanta extends Bebida {

    public Fanta(int serie, PrecioProducto precioProducto) {
        super(serie, precioProducto.FANTA);
    }

    public String ingerir(){
        return "Fanta";
    }

}