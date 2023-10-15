package com.example;
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

/*
class Expendedor {
    private int precioProductos;
    private DepositoGenerico<Producto> productos;
    private DepositoGenerico<Moneda> monedas;
    private DepositoGenerico<Moneda> monedasVuelto;

    public Expendedor(int cantidadProductos, int cantidadMonedas) {
        precioProductos = PrecioProducto.COCA.getPrecio(); // Precio base
        productos = new DepositoGenerico<>();
        monedas = new DepositoGenerico<>();
        monedasVuelto = new DepositoGenerico<>();

        for (int i = 0; i < cantidadProductos; i++) {
            productos.addItem(new CocaCola(1,PrecioProducto.COCA));
            productos.addItem(new Sprite(2,PrecioProducto.SPRITE));
            productos.addItem(new Fanta(3,PrecioProducto.SPRITE));
            productos.addItem(new Snicker(4, PrecioProducto.SNICKERS));
            productos.addItem(new Super8(5, PrecioProducto.SUPER8));
        }
        for (int i = 0; i < cantidadMonedas; i++) {
            monedas.addItem(new Moneda100());
            monedas.addItem(new Moneda500());
            monedas.addItem(new Moneda1000());
        }
    }
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

