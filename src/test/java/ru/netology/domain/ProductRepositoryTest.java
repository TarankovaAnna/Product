package ru.netology.domain;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class ProductRepositoryTest {

    Product book1 = new Book(1, "Над пропостью во ржи", 500, "Джером Селенжер");
    Product book2 = new Book(20, "Отцы и дети", 485, "Иван Тургеенев");
    Product book3 = new Book(31, "Преступление и наказание", 689, "Федор Достоевский");
    Product book4 = new Book(1000, "Война и мир", 1500, "Лев Толстой");
    Product smartphone1 = new Smartphone(6, "Galaxy S21", 68_000, "Samsung");
    Product smartphone2 = new Smartphone(2, " Galaxy S22", 82_500, "Samsung");
    Product smartphone3 = new Smartphone(32, "Apple iPhone 14", 79_999, "Apple");
    Product smartphone4 = new Smartphone(4, "Xiaomi Redmi 9C", 7_900, "XIAOMI");
    Product smartphone5 = new Smartphone(5, "Honor X8", 19_800, "Honor");


    @Test
    public void shouldSaveAllProducts() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(smartphone4);
        repo.save(smartphone5);

        Product[] expected = {book1, book2, book3, book4, smartphone1, smartphone2, smartphone3, smartphone4, smartphone5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }


    @Test
    public void shouldSaveOneProduct() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);

        Product[] expected = {book1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSaveZeroProducts() {
        ProductRepository repo = new ProductRepository();

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveEightProducts() {
        ProductRepository repo = new ProductRepository();
        repo.save(book4);
        repo.save(smartphone5);
        repo.save(book3);
        repo.save(book2);
        repo.save(smartphone4);
        repo.save(book1);
        repo.save(smartphone3);
        repo.save(smartphone2);

        Product[] expected = {book4, smartphone5, book3, book2, smartphone4, book1, smartphone3, smartphone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveTwoSameProducts() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book1);

        Product[] expected = {book1, book1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

//тестируем удаление по ID


    @Test
    public void shouldRemoveOneProduct() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(smartphone4);
        repo.save(smartphone5);

        repo.removeById(book3.getId());


        Product[] expected = {book1, book2, book4, smartphone1, smartphone2, smartphone3, smartphone4, smartphone5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveTwoProducts() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(smartphone4);
        repo.save(smartphone5);

        repo.removeById(book4.getId());
        repo.removeById(book3.getId());


        Product[] expected = {book1, book2, smartphone1, smartphone2, smartphone3, smartphone4, smartphone5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAllBooks() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(smartphone4);
        repo.save(smartphone5);

        repo.removeById(book1.getId());
        repo.removeById(book2.getId());
        repo.removeById(book4.getId());
        repo.removeById(book3.getId());


        Product[] expected = {smartphone1, smartphone2, smartphone3, smartphone4, smartphone5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldDeleteAllProducts() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(smartphone4);
        repo.save(smartphone5);

        repo.removeById(book1.getId());
        repo.removeById(book2.getId());
        repo.removeById(book4.getId());
        repo.removeById(book3.getId());
        repo.removeById(smartphone1.getId());
        repo.removeById(smartphone2.getId());
        repo.removeById(smartphone3.getId());
        repo.removeById(smartphone4.getId());
        repo.removeById(smartphone5.getId());

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldDoNotRemoveOneProduct() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(smartphone4);
        repo.save(smartphone5);

        repo.removeById(book2.getId());
        repo.removeById(book4.getId());
        repo.removeById(book3.getId());
        repo.removeById(smartphone1.getId());
        repo.removeById(smartphone2.getId());
        repo.removeById(smartphone3.getId());
        repo.removeById(smartphone4.getId());
        repo.removeById(smartphone5.getId());

        Product[] expected = {book1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }


}

