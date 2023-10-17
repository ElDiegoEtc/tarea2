package com.example;
abstract class Moneda implements Comparable<Moneda>{

    public Moneda() {
    }
    public Moneda getSerie() {
        return this;
    }

    public abstract int getValor();

    public int compareTo(Moneda anycoin){
        int comparacion = Integer.compare(this.getValor(), anycoin.getValor());
        return comparacion;
    }

}