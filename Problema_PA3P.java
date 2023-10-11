package com.example;

import java.util.ArrayList;

public class Problema103 {
    public static void main(String[] args) {

        Expendedor exp = new Expendedor(3,1000);
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

class Expendedor {
    public static final int COCA=1;
    public static final int SPRITE=2;

    private int precioBebidas;
    private Deposito coca;
    private Deposito sprite;
    private DepositoM monVu;

    public Expendedor(int numBebidas, int precioBebidas) {
        coca = new Deposito();
        sprite = new Deposito();
        monVu = new DepositoM();
        this.precioBebidas = precioBebidas;

        int c = 100, s = 200;
        for(int i = 0; i < numBebidas; i++) {
            Bebida cola = new CocaCola(c);
            Bebida sprt = new Sprite(s);
            coca.addBebida(cola);
            sprite.addBebida(sprt);
            c++;
            s++;
        }
    }

    public Bebida comprarBebida(Moneda m, int cual){
        Bebida b = null;

        if(m!=null && m.getValor()>=precioBebidas){
            if(cual==COCA)      b=coca.getBebida();
            else if(cual==SPRITE) b=sprite.getBebida();

            if(b!=null){
                int n = (m.getValor()-precioBebidas)/100;
                while (n>0) {
                    monVu.addMoneda(new Moneda100());
                    n--;
                }
            }
        }
        if(b==null || m.getValor()<precioBebidas) monVu.addMoneda(m);
        return b;
    }

    public Moneda getVuelto() {
        return monVu.getMoneda();
    }

}

class Comprador {
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int eleccion, Expendedor exp) {
        Bebida b = exp.comprarBebida(m, eleccion);

        Moneda moneda = null;
        while((moneda = exp.getVuelto()) != null) {
            this.vuelto += moneda.getValor();
        }  
        if(b != null) {
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

class DepositoM {
    private ArrayList<Moneda> monedas;

    public DepositoM() {
        monedas = new ArrayList<Moneda>();
    }

    public void addMoneda(Moneda mon) {
        monedas.add(mon);
    }

    public Moneda getMoneda() {
        if(monedas.size() == 0) {
            return null;
        }
        return monedas.remove(0);
    }

}

abstract class Bebida {
    private int serie;
    
    public Bebida(int serie) {
        this.serie = serie;
    }

    public int getSerie() {
        return serie;
    }

    public abstract String beber();
    
}

class CocaCola extends Bebida {

    public CocaCola(int serie) {
        super(serie);
    }

    public String beber() {
        return "cocacola";
    }

}

class Sprite extends Bebida {

    public Sprite(int serie) {
        super(serie);
    }

    public String beber() {
        return "sprite";
    }

}

abstract class Moneda {

    public Moneda() {

    }

    public Moneda getSerie() {
        return this;
    }

    public abstract int getValor();

}


class Moneda100 extends Moneda {

    public Moneda100() {
        super();
    }

    public int getValor() {
        return 100;
    }

}

class Moneda500 extends Moneda {

    public Moneda500() {
        super();
    }

    public int getValor() {
        return 500;
    }

}

class Moneda1000 extends Moneda {

    public Moneda1000() {
        super();
    }

    public int getValor() {
        return 1000;
    }

} 

class Moneda1500 extends Moneda {

    public Moneda1500() {
        super();
    }

    public int getValor() {
        return 1500;
    }

}
