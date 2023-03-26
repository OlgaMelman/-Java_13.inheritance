package ru.netology.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();

    @Test
    public void shouldAddProduct() {
        Product product = new Product(5, "Сапиенс", 400);

        repository.save(product);

        Product[] expected = {product};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        Product product1 = new Product(4, "Линейка", 15);
        Product product2 = new Product(6, "Домик", 20);

        repository.save(product1);
        repository.save(product2);
        repository.removeById(6);

        Product[] expected = {product1};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected,actual);


    }
}
