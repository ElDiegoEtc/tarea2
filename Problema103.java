package com.example;

import java.util.ArrayList;

public class Problema103 {
    public static void main(String[] args) {

        // creamos el expendedor

        Expendedor exp = new Expendedor(3);

        // Comprador a compra una sprite con una moneda de 1500
        Moneda m = new Moneda1500();
        Comprador c = new Comprador(m, Valoresserie.SPRITE.ordinal(), exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());


        // Comprador b intenta compra sprite con 1000
        m = new Moneda1000();
        c = new Comprador(m, Valoresserie.SPRITE.ordinal(), exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());

        // Comprador c  compra sprite con coca 1000

        m = new Moneda1000();
        c = new Comprador(m, Valoresserie.COCA.ordinal(), exp);
        System.out.println(c.queBebiste() + ",  " + c.cuantoVuelto());



        // Comprador e  compra un Snicker con una moneda de 1500
        m = new Moneda1500();
        c = new Comprador(m, Valoresserie.SNICKER.ordinal(), exp);
        System.out.println(c.queBebiste() + "," + c.cuantoVuelto());

        m = new Moneda1500();
        c = new Comprador(m, Valoresserie.SUPER8.ordinal(), exp);
        System.out.println(c.queBebiste() + "," + c.cuantoVuelto());
    }
}


