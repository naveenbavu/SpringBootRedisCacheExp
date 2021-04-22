package com.redisexample.redisexample.controller;

import com.redisexample.redisexample.entity.Product;
import com.redisexample.redisexample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Naveen Bavu
 */
@RestController
@RequestMapping("products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @PostMapping
  public ResponseEntity<Product> createProducts(@RequestBody Product product) {
    return new ResponseEntity(productService.createProducts(product), HttpStatus.OK);

  }

  @GetMapping
  public Flux<Product> findAll() {
    return productService.getAllProducts();
  }

  @GetMapping(path = "/{id}")
  public Product getProductById(@PathVariable("id") Long productId) {
    return productService.getproductById(productId);
  }

  @DeleteMapping(path = "/")
  public void deleteProducts() {
    productService.deleteProducts();
  }

  @DeleteMapping(path = "/{id}")
  public void deleteProductById(@PathVariable("id") Long id) {
    productService.deleteProductById(id);
  }
}
