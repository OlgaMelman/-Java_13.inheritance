package ru.netology.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    @Test
    public void shouldAddProductToManager() {
        Book book = new Book(5, "Сапиенс", 50, "Харари");

        manager.add(book);

        Product[] expected = {book};
        Product[] actual = manager.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowEmpty() {

        Product[] expected = new Book[0];
        Product[] actual = manager.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindProduct() {
        Book book1 = new Book(5, "Сапиенс", 450, "Харари");
        Smartphone smart2 = new Smartphone(6, "mi", 20_000, "Xiaomi");
        Book book3 = new Book(8, "Финансист", 500, "Драйзер");
        Smartphone smart4 = new Smartphone(1, "iphone", 60_000,"Apple");

        manager.add(book1);
        manager.add(smart2);
        manager.add(book3);
        manager.add(smart4);

        Product[] expected = {smart2};
        Product[] actual = manager.searchBy("mi");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFinIfNoProduct() {
        Book book1 = new Book(5, "Сапиенс", 450, "Харари");
        Smartphone smart2 = new Smartphone(6, "mi", 20_000, "Xiaomi");
        Book book3 = new Book(8, "Финансист", 500, "Драйзер");
        Smartphone smart4 = new Smartphone(1, "iphone", 60_000,"Apple");

        manager.add(book1);
        manager.add(smart2);
        manager.add(book3);
        manager.add(smart4);

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Кружкка");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFinIfNoProducts() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Кружкка");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFinIfNoProduct1() {
        Book book1 = new Book(5, "Сапиенс", 450, "Харари");
        Smartphone smart2 = new Smartphone(6, "i", 20_000, "Xiaomi");
        Book book3 = new Book(8, "Финансист", 500, "Драйзер");
        Smartphone smart4 = new Smartphone(1, "i", 60_000,"Apple");

        manager.add(book1);
        manager.add(smart2);
        manager.add(book3);
        manager.add(smart4);

        Product[] expected = {smart2,smart4};
        Product[] actual = manager.searchBy("i");

        Assertions.assertArrayEquals(expected, actual);
    }
}
