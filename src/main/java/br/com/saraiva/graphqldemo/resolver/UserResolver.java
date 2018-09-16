package br.com.saraiva.graphqldemo.resolver;

import static org.springframework.data.domain.Sort.Direction.DESC;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import br.com.saraiva.graphqldemo.model.Order;
import br.com.saraiva.graphqldemo.model.User;

/**
 * Created by sara on set, 2018
 */
@Component
public class UserResolver implements GraphQLResolver<User> {

	private final MongoTemplate mongoTemplate;

	@Autowired
	public UserResolver(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public List<Order> orders(User user, int last) {

		return mongoTemplate.find(
				query(where("_id").in(user.getOrders().orElse(Collections.emptyList())))
						.limit(last).with(new Sort(DESC, "_id")),
				Order.class);
	}

}