package br.com.saraiva.graphqldemo.resolver;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import br.com.saraiva.graphqldemo.model.Order;
import br.com.saraiva.graphqldemo.model.User;
import br.com.saraiva.graphqldemo.repository.OrderRepository;

/**
 * Created by sara on set, 2018
 */
@Component
public class UserResolver implements GraphQLResolver<User> {

	private final OrderRepository orderRepository;
	private final MongoTemplate mongoTemplate;

	@Autowired
	public UserResolver(OrderRepository orderRepository, MongoTemplate mongoTemplate) {
		this.orderRepository = orderRepository;
		this.mongoTemplate = mongoTemplate;
	}

	public List<Order> orders(User user) {

		return mongoTemplate.find(
				query(where("_id").in(user.getOrders().orElse(Collections.emptyList()))),
				Order.class);
	}

}