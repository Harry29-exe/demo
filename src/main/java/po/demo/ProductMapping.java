package po.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import po.demo.persistence.Product;
import po.demo.persistence.ProductRepo;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ProductMapping {
    private final ProductRepo productRepo;

    @Autowired
    public ProductMapping(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping("/products")
    public List<Product> getTextObjects(
            @RequestParam(required = false) Integer amount,
            @RequestParam(required = false) Boolean allDetails) {
        amount = amount == null? 100: amount;


        return productRepo.getProducts(amount);
    }

    @GetMapping("/product")
    public Product getProduct(@RequestParam int id) {
        return productRepo.getProduct(id);
    }

    private static class SimpleProduct {

    }
}
