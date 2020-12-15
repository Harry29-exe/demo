package po.demo.persistence;

import java.util.List;

public interface ProductRepo {
    List<Product> getProducts();

    List<Product> getProducts(int amount);

    Product getProduct(int id);

    void addProduct(Product product);

    void removeProduct(int id);
}
