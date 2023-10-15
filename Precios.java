package com.example;
//clase para enum para establecer los precios de cada producto
enum Precios {
    COCA(1000),
    SPRITE(1000),
    FANTA(1000),
    SNICKERS(1500),
    SUPER8(1200);

    private final int precio;

    Precios(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }
}