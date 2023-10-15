package com.example;
class Sprite extends Bebida {

    public Sprite(int serie, PrecioProducto precioProducto) {
        super(serie, precioProducto.SPRITE);
    }

    public String ingerir(){
        return "Sprite";
    }

}
