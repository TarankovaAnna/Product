package ru.netology.domain;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import ru.netology.domain.ProductManager;
import ru.netology.domain.ProductRepository;


public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);


    Product book1 = new Book(1, "Над пропостью во ржи", 500, "Джером Селенжер");
    Product book2 = new Book(20, "Отцы и дети", 485, "Иван Тургеенев");
    Product book3 = new Book(31, "Преступление и наказание", 689, "Федор Достоевский");
    Product book4 = new Book(1000, "Война и мир", 1500, "Лев Толстой");
    Product smartphone1 = new Smartphone(6, "Galaxy S21", 68_000, "Samsung");
    Product smartphone2 = new Smartphone(2, " Galaxy S22", 82_500, "Samsung");
    Product smartphone3 = new Smartphone(32, "Apple iPhone 14", 79_999, "Apple");
    Product smartphone4 = new Smartphone(4, "Xiaomi Redmi 9C", 7_900, "XIAOMI");
    Product smartphone5 = new Smartphone(5, "Honor X8", 19_800, "Honor");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);
    }

    @Test
    public void shouldSearch() {


        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Отцы и дети");


        Assertions.assertArrayEquals(expected, actual);
    }
}