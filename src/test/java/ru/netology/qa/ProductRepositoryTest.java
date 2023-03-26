package ru.netology.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();

    @Test
    public void shouldAddProduct() {
        Book book = new Book(5, "Сапиенс", 50, "Харари");

        repository.save(book);

        Product[] expected = {book};
        Product [] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        Book book1 = new Book(5, "Сапиенс", 450, "Харари");
        Smartphone smart2 = new Smartphone(6, "mi", 20_000, "Xiaomi");

        repository.save(book1);
        repository.save(smart2);
        repository.removeById(6);

        Product[] expected = {book1};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected,actual);

    }

}
