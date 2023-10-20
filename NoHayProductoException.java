package com.example;

public class NoHayProductoException extends Exception {
    public NoHayProductoException(String mensage){
        super(mensage);
    }
}
