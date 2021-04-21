package com.redisexample.redisexample.repository;

import com.redisexample.redisexample.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Naveen Bavu
 */
@Repository
public interface ProductRepository  extends ReactiveMongoRepository<Product,Long> {



}
