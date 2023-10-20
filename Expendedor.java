package com.example;

/**
 * @class
 */
class Expendedor {
    private int precioProductos;
    private DepositoGenerico<Producto> coca;
    private DepositoGenerico<Producto> sprite;
    private DepositoGenerico<Producto> fanta;
    private DepositoGenerico<Producto> snicker;
    private DepositoGenerico<Producto> super8;
    private DepositoGenerico<Moneda> monedasVuelto;

    /**
     *
     * @param cantidadProductos
     */
    public Expendedor(int cantidadProductos) {
        precioProductos = PrecioProducto.COCA.getPrecio(); // Precio base
        coca = new DepositoGenerico<>();
        fanta = new DepositoGenerico<>();
        sprite = new DepositoGenerico<>();
        snicker = new DepositoGenerico<>();
        super8 = new DepositoGenerico<>();
        monedasVuelto = new DepositoGenerico<>();

        for (BucleProducto producto : BucleProducto.values()) {
            for (int i = 0; i < cantidadProductos; i++) {
                if (producto == BucleProducto.c) {
                    coca.addItem(new CocaCola(producto.getN(), PrecioProducto.COCA));
                } else if (producto == BucleProducto.s) {
                    sprite.addItem(new Sprite(producto.getN(), PrecioProducto.SPRITE));
                } else if (producto == BucleProducto.f) {
                    fanta.addItem(new Fanta(producto.getN(), PrecioProducto.FANTA));
                } else if (producto == BucleProducto.sn) {
                    snicker.addItem(new Snicker(producto.getN(), PrecioProducto.SNICKER));
                } else if (producto == BucleProducto.S8) {
                    super8.addItem(new Super8(producto.getN(), PrecioProducto.SUPER8));
                }
            }
        }
    }

    /**
     *
     * @param m
     * @param eleccion
     * @return
     */
    public Producto comprarProducto(Moneda m, int eleccion) throws NoHayProductoException,
            PagoInsuficienteException, PagoIncorrectoException {
        Producto p = null;
        if (m == null) throw new PagoIncorrectoException ("Pago no relizado");
        if (m.getValor() < precioProductos) throw new PagoInsuficienteException("Pago Insuficiente, " + m.getValor());
        if (m != null && m.getValor() >= precioProductos) {
            if (eleccion == Valoresserie.COCA.getNum()) {
                p = coca.getItem();
                precioProductos = PrecioProducto.COCA.getPrecio();
            } else if (eleccion == Valoresserie.SPRITE.getNum()) {
                p = sprite.getItem();
                precioProductos = PrecioProducto.SPRITE.getPrecio();
            } else if (eleccion == Valoresserie.FANTA.getNum()) {
                p = fanta.getItem();
                precioProductos = PrecioProducto.FANTA.getPrecio();
            } else if (eleccion == Valoresserie.SNICKER.getNum()) {
                p = snicker.getItem();
                precioProductos = PrecioProducto.SNICKER.getPrecio();
            } else if (eleccion == Valoresserie.SUPER8.getNum()) {
                p = super8.getItem();
                precioProductos = PrecioProducto.SUPER8.getPrecio();
            }
            if (p == null) throw new NoHayProductoException("No hay producto de lo solicitado, " + m.getValor());
            if (p != null) {
                int n = (m.getValor() - precioProductos) / 100;
                while (n > 0) {
                    monedasVuelto.addItem(new Moneda100());
                    n--;
                }
            }
        }
        if (p == null || m.getValor() < precioProductos) monedasVuelto.addItem(m);
        return p;
    }

    /**
     *
     * @return
     */
    public Moneda getVuelto() {
        return monedasVuelto.getItem();
    }
}