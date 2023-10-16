package com.example;
class Expendedor {
    public static final int COCA=1, SPRITE=2, FANTA=3, SNICKER=4, SUPER8= 5; //REMPLAZAR CON ENUM EXTRA
    private int precioProductos;
    private DepositoGenerico<Producto> coca;
    private DepositoGenerico<Producto> sprite;
    private DepositoGenerico<Producto> fanta;
    private DepositoGenerico<Producto> snicker;
    private DepositoGenerico<Producto> super8;
    private DepositoGenerico<Moneda> monedas;
    private DepositoGenerico<Moneda> monedasVuelto;

    public Expendedor(int cantidadProductos) {
        precioProductos= PrecioProducto.COCA.getPrecio(); // Precio base
        coca = new DepositoGenerico<>();
        fanta = new DepositoGenerico<>();
        sprite = new DepositoGenerico<>();
        snicker = new DepositoGenerico<>();
        super8 = new DepositoGenerico<>();
        monedas = new DepositoGenerico<>();
        monedasVuelto = new DepositoGenerico<>();
        //creo que se puede resumir asi: DepositoGenerico<?> coca, fanta, sprite, snicker, super8, monedas, monedasVuelto;

        int c =0, s=1000, f=2000 ,sn=3000 ,S8=4000 ;
        for (int i = 0; i < cantidadProductos; i++) {
            coca.addItem(new CocaCola(c,PrecioProducto.COCA));
            sprite.addItem(new Sprite(s,PrecioProducto.SPRITE));
            fanta.addItem(new Fanta(f,PrecioProducto.FANTA));
            snicker.addItem(new Snicker(sn, PrecioProducto.SNICKERS));
            super8.addItem(new Super8(S8, PrecioProducto.SUPER8));
            c++;
            s++;
            f++;
            sn++;
            S8++;
        }
    }

    public Producto comprarProducto(Moneda m, int eleccion){
        Producto p = null;

        if(m!=null && m.getValor()>=precioProductos){
            if(eleccion==COCA)      p=coca.getItem();
            else if(eleccion==SPRITE) p=sprite.getItem();
            else if(eleccion==FANTA) p=fanta.getItem();
            else if(eleccion==SNICKER) p=snicker.getItem();
            else if(eleccion==SUPER8) p=super8.getItem();

            if(p!=null){
                int n = (m.getValor()-precioProductos)/100;
                while (n>0) {
                    monedasVuelto.addItem(new Moneda100());
                    n--;
                }
            }
        }
        if(p==null || m.getValor()<precioProductos) monedasVuelto.addItem(m);
        return p;
    }

    public Moneda getVuelto() {
        return monedasVuelto.getItem();
    }
}

/*
class Expendedor {

    /*public Producto comprarProducto(Moneda moneda, PrecioProducto precioProducto)
            throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {
        if (moneda == null) {
            throw new PagoIncorrectoException();
        }

        Producto producto = null;

        if (productos.isEmpty()) {
            throw new NoHayProductoException();
        }

        int precioProducto = tipoProducto.getPrecio();

        if (moneda.getValor() < precioProducto) {
            throw new PagoInsuficienteException(precioProducto - moneda.getValor());
        }

        producto = productos.getItem();
        monedasVuelto.addMoneda(new Moneda(moneda.getValor() - precioProducto));

        return producto;
    }

    public Moneda getVuelto() {
        return monedasVuelto.getItem();
    }
}
*/
