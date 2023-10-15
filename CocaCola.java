package com.example;

class CocaCola extends Bebida {

    public CocaCola(int serie, PrecioProducto precioProducto) {
        super(serie, precioProducto.COCA);
    }

    public String ingerir(){
        return "CocaCola";
    }

}
