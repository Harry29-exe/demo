package po.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import po.demo.persistence.Product;
import po.demo.persistence.ProductRepo;

import javax.servlet.http.HttpServletResponse;
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
        amount = amount == null ? 100 : amount;
        List<Product> products = productRepo.getProducts(amount);

        if (allDetails == null || allDetails)
            return products;

        for(Product p : products) {
            p.setImgUrl(null);
            p.setDescription(null);
        }
        return products;
    }

    @GetMapping("/product")
    public Product getProduct(@RequestParam int id) {
        return productRepo.getProduct(id);
    }

    @DeleteMapping("/product")
    public void deleteProduct(@RequestParam int id, HttpServletResponse response) {
        response.setStatus(501);
    }

    @PostMapping("/product")
    public void addProduct(@RequestBody Product product, HttpServletResponse response) {
        response.setStatus(501);
    }
}
