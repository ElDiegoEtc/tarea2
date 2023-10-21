package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CompradorTest {
    private Moneda m;
    private Expendedor e;
    private Comprador c;

    @BeforeEach
    public void setUp(){
        m = new Moneda1000();
        e = new Expendedor(10);
    }
    @Test
    public void testCuantoVuelto() throws Exception{
        c = new Comprador(m, 1, e);

        assertEquals(0, c.cuantoVuelto());
    }
    @Test
    public void testqueBebiste() throws Exception{
        c = new Comprador(m, 3, e);

        assertEquals("Fanta", c.queBebiste());
    }
}