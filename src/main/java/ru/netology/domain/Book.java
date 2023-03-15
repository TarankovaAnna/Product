package ru.netology.domain;

public class Book extends Product {
    protected String author;

    protected String getAuthor() {
        return author;
    }

    protected Book(int id, String name, int price, String author) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
    }

}
