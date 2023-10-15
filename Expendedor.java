package com.example;
class Expendedor {
    private int precioProductos;
    private DepositoGenerico<Producto> productos;
    private DepositoGenerico<Moneda> monedas;
    private DepositoGenerico<Moneda> monedasVuelto;

    public Expendedor(int cantidadProductos, int cantidadMonedas) {
        precioProductos = TipoProducto.COCA.getPrecio(); // Precio base
        productos = new DepositoGenerico<>();
        monedas = new DepositoGenerico<>();
        monedasVuelto = new DepositoGenerico<>();

        for (int i = 0; i < cantidadProductos; i++) {
            productos.addItem(new Bebida(TipoProducto.COCA));
            productos.addItem(new Bebida(TipoProducto.SPRITE));
            productos.addItem(new Dulce(TipoProducto.SNICKERS));
            productos.addItem(new Dulce(TipoProducto.SUPER8));
        }

        for (int i = 0; i < cantidadMonedas; i++) {
            monedas.addItem(new Moneda(100));
            monedas.addItem(new Moneda(500));
            monedas.addItem(new Moneda(1000));
        }
    }
    public Producto comprarProducto(Moneda moneda, TipoProducto tipoProducto)
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
        return monedasVuelto.getMoneda();
    }
}

