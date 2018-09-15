package br.com.saraiva.graphqldemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.saraiva.graphqldemo.repository.OrderRepository;
import br.com.saraiva.graphqldemo.repository.PetRepository;
import br.com.saraiva.graphqldemo.repository.UserRepository;
import br.com.saraiva.graphqldemo.resolver.Mutation;
import br.com.saraiva.graphqldemo.resolver.Query;
import br.com.saraiva.graphqldemo.utils.Scalars;
import graphql.schema.GraphQLScalarType;

/**
 * Created by sara on set, 2018
 */
@Configuration
public class GraphQLConfiguration {

	private final PetRepository petRepository;
	private final OrderRepository orderRepository;
	private final UserRepository userRepository;

	@Autowired
	public GraphQLConfiguration(PetRepository petRepository,
			OrderRepository orderRepository, UserRepository userRepository) {
		this.petRepository = petRepository;
		this.orderRepository = orderRepository;
		this.userRepository = userRepository;
	}

	@Bean
	public Query query() {
		return new Query(petRepository, orderRepository, userRepository);
	}

	@Bean
	public Mutation mutation() {
		return new Mutation(petRepository, orderRepository, userRepository);
	}

	@Bean
	public GraphQLScalarType dateTime() {
		return Scalars.dateTime;
	}

	@Bean
	public GraphQLScalarType email() {
		return Scalars.email;
	}
}
