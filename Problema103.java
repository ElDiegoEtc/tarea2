package com.example;

import java.util.ArrayList;

public class Problema103 {
    public static void main(String[] args) {

        Expendedor exp = new Expendedor(3);
        Moneda m = null;
        Comprador c=null;
        m = new Moneda1500();
        c = new Comprador(m,Expendedor.SPRITE,exp);
        System.out.println(c.queBebiste()+", " + c.cuantoVuelto());
        m = new Moneda1500();
        c = new Comprador(m,Expendedor.SPRITE,exp);
        System.out.println(c.queBebiste()+", " + c.cuantoVuelto());
        m = new Moneda1500();
        c = new Comprador(m,Expendedor.SPRITE,exp);
        System.out.println(c.queBebiste()+", " + c.cuantoVuelto());
        m = new Moneda1500();
        c = new Comprador(m,Expendedor.SPRITE,exp);
        System.out.println(c.queBebiste()+", " + c.cuantoVuelto());


    }
}

