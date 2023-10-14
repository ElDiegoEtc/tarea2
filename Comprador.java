package com.example;

class Comprador {
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int eleccion, Expendedor exp) {
        Bebida b = exp.comprarBebida(m, eleccion);

        Moneda moneda = null;
        while ((moneda = exp.getVuelto()) != null) {
            this.vuelto += moneda.getValor();
        }
        if (b != null) {
            this.sonido = b.beber();
        }
    }

    public int cuantoVuelto() {
        return vuelto;
    }

    public String queBebiste() {
        return sonido;
    }

}
