package com.example;

class CocaCola extends Bebida {

    public CocaCola(int serie) {
        super(serie);
    }
    public String ingerir(){
        return "bebiendo";
    }

    public String beber() {
        return "cocacola";
    }

}
