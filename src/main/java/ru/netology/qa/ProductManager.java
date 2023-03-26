package ru.netology.qa;

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }

    public Product[] getItems() {
        Product[] all = repo.findAll();
        return all;
    }

    public Product[] searchBy(String search) {
        Product[] result = new Product[0];// тут будем хранить подошедшие запросу продукты
        for (Product product : repo.findAll()) {
            if (product.matches(search)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}
