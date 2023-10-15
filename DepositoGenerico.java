package com.example;

import java.util.ArrayList;

public class DepositoGenerico<T> {
    private ArrayList<T> items;

    public DepositoGenerico() {
        items = new ArrayList<>();
    }

    public void additem(T item) {
        items.add(item);
    }

    public T getitem() {
        if (items.size() == 0) {
            return null;
        } else {
            return items.remove(0);
        }
    }
}