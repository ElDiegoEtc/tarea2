package com.example;

import java.util.ArrayList;

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
