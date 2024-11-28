package com.example.users.service;

import com.example.users.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final List<Product> productList;

    public ProductService() {
        productList = new ArrayList<>();

        Product product1 = new Product(1, "Arroz");
        Product product2 = new Product(2, "Algodão");
        Product product3 = new Product(3, "Batata");
        Product product4 = new Product(4, "Cenoura");

        productList.addAll(Arrays.asList(product1, product2, product3, product4));
    }

    public Optional<Product> getProductById(Integer id) {
        Optional<Product> optional = Optional.empty();

        for(Product product: productList) {
            if(id == product.getId()) {
                optional = Optional.of(product);
                return optional;
            }
        }

        return optional;
    }

    public Optional<List<Product>> getAllProducts() {
        Optional<List<Product>> optional = Optional.empty();

        optional = Optional.of(productList);
        return optional;

    }



    public Optional<Product> createProduct(String name) {
        Optional <Product> optional = Optional.empty();

        int id = (productList.getLast()).getId() + 1;
        Product newProduct = new Product(id, name);
        productList.add(newProduct);

        optional = Optional.of(newProduct);

        return optional;
    }

    public Optional<Product> editProduct(Product product) {
        Optional <Product> optional = Optional.empty();

        int index=0;
        for(Product currentProduct: productList) {
            if(product.getId() == currentProduct.getId()) {
                optional = Optional.of(product);
                productList.set(index, product);
                return optional;
            }
            index++;
        }
        return optional;
    }

    public void deleteProduct(int id) {
        productList.removeIf(product -> (product.getId() == id));
    }
}