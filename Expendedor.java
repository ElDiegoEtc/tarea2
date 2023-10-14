package com.example;

public class Expendedor {
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