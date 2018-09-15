package br.com.saraiva.graphqldemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.saraiva.graphqldemo.model.Order;

/**
 * Created by sara on set, 2018
 */
public interface OrderRepository extends MongoRepository<Order, String> {
}
