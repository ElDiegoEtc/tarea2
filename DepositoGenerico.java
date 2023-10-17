package com.example;

import java.util.ArrayList;

public class DepositoGenerico<T> {

    private ArrayList<T> items;

    public DepositoGenerico() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem() {
        if (items.size() == 0) {
            return null;
        } else {
            return items.remove(0);
        }
    }
}