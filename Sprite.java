package com.example;
class Sprite extends Bebida {

    public Sprite(int serie) {
        super(serie);
    }

    public String ingerir(){
        return "bebiendo";
    }

    public String beber() {
        return "Sprite";
    }

}
