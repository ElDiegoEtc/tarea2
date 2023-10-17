package com.example;

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
        return num;}
}
