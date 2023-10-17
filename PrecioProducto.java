package com.example;

enum PrecioProducto {
    COCA(1000),
    SPRITE(1000),
    FANTA(1000),
    SNICKER(1500),
    SUPER8(1200);

    private final int precio;

    PrecioProducto(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;}
}