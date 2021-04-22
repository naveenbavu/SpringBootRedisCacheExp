package com.redisexample.redisexample.service;

import com.redisexample.redisexample.entity.Product;
import com.redisexample.redisexample.repository.ProductRepository;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Naveen Bavu
 */
@Component
//@CacheConfig(cacheNames = {"product"})
public class ProductService implements Serializable {

  @Autowired
  private ProductRepository productRepository;

  @CachePut(value = "product", key = "#product.id")
  public Product createProducts(Product product) {
    Product productRes = null;
    try {
      productRes = productRepository.save(product).block();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return productRes;
  }

  public Flux<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public void deleteProduct(Product product) {
    productRepository.delete(product).block();
  }

  public void deleteProducts() {
    productRepository.deleteAll().block();
  }

  @Cacheable(value = "product", key = "#id")
  public Product getproductById(Long id) {
    System.out.println("====from database=====");
    return productRepository.findById(id).block();
  }
  @CacheEvict(value = "product", key = "#id")
  public void deleteProductById(Long id) {
    productRepository.deleteById(id).block();
  }
}
