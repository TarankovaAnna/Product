package ru.netology.domain;

public class Smartphone extends Product {
    protected String maker;

    protected String getMaker() {
        return maker;
    }

    protected Smartphone(int id, String name, int price, String maker) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.maker = maker;
    }
}
