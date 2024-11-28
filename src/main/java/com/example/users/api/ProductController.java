package com.example.users.api;

import com.example.users.model.Product;
import com.example.users.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public Product getProduct(@RequestParam Integer id) {
        Optional<Product> product = productService.getProductById(id);

        return  (Product) product.orElse(null);
    }

    @GetMapping("/allProducts")
    public List<Product> getAllProducts() {
        Optional<List<Product>> product = productService.getAllProducts();

        return  (List<Product>) product.orElse(null);
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product) {

        Optional<Product> newproduct =
                productService.createProduct(product.getName(),
                        product.getAge(), product.getEmail());

        return (Product) newproduct.orElse(null);
    }

    @PutMapping("/product")
    public Product editProduct(@RequestBody Product product) {

        Optional<Product> editedProduct =
                productService.editProduct(product);

        return (Product) editedProduct.orElse(null);
    }

    @DeleteMapping("/product")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@RequestParam int id) {
        productService.deleteProduct(id);
    }

}