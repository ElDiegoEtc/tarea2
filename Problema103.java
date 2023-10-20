package com.example;

import java.util.ArrayList;

public class Problema103 {
    public static void main(String[] args) {

        Expendedor exp = new Expendedor(2);
        Comprador c;
        Moneda m;

        try{
            /*
            m = null;
            c = new Comprador(m, 5, exp);
            System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());
            EXEPCION DE NO MONEDA

            m = new Moneda500();
            c = new Comprador(m, 1, exp);
            System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());
            EXEPCION DE PAGO INSUFICIENTE POR UN PRODUCTO
            */

            m = new Moneda1000();
            c = new Comprador(m, 2, exp);
            System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());

            m = new Moneda1000();
            c = new Comprador(m, 5, exp);
            System.out.println(c.queBebiste() + ",  " + c.cuantoVuelto());

            m = new Moneda1500();
            c = new Comprador(m, 4, exp);
            System.out.println(c.queBebiste() + "," + c.cuantoVuelto());

            m = new Moneda1500();
            c = new Comprador(m, 2, exp);
            System.out.println(c.queBebiste() + "," + c.cuantoVuelto());

            /*
            m = new Moneda1500();
            c = new Comprador(m, 2, exp);
            System.out.println(c.queBebiste() + "," + c.cuantoVuelto());
            EXEPCION DE NO HAY MAS PRODUCTO
             */

        } catch (PagoIncorrectoException e){
            System.out.println(e.getMessage());

        } catch (PagoInsuficienteException e){
            System.out.println(e.getMessage());

        } catch (NoHayProductoException e){
            System.out.println(e.getMessage());
        }

    }
}


