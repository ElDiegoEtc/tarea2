package com.example;

class Comprador {
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int eleccion, Expendedor exp) {
        Producto p = exp.comprarProducto(m, eleccion);

        Moneda moneda = null;
        while ((moneda = exp.getVuelto()) != null) {
            this.vuelto += moneda.getValor();
        }
        if (p != null) {
            this.sonido = p.ingerir();
        }
    }
    public int cuantoVuelto() {
        return vuelto;
    }

    public String queBebiste() {
        return sonido;
    }

}
