package com.example;

/**
 *
 */
enum Valoresserie {
    COCA(1),
    SPRITE(2),
    FANTA(3),
    SNICKER(4),
    SUPER8(5);
    private final int num;



    Valoresserie(int num) {
        this.num= num;
    }

    public int getNum() {
        return num;
    }
}


enum BucleProducto {
    c(0),
    s(1000),
    f(2000),
    sn(3000),
    S8(4000);
    private final int n;

    BucleProducto(int n) {
        this.n= n;
    }

    public int getN() {
        return n;}
}
