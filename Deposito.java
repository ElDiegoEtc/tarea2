package com.example;

        import java.util.ArrayList;

class Deposito {
    private ArrayList<Bebida> bebidas;

    public Deposito() {
        bebidas = new ArrayList<Bebida>();
    }

    public void addBebida(Bebida bebida) {
        bebidas.add(bebida);
    }

    public Bebida getBebida() {
        if(bebidas.size() == 0) {
            return null;
        }
        return bebidas.remove(0);
    }

}