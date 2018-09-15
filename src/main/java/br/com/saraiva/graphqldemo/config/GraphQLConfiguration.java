package br.com.saraiva.graphqldemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.saraiva.graphqldemo.repository.OrderRepository;
import br.com.saraiva.graphqldemo.repository.PetRepository;
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

	@Autowired
	public GraphQLConfiguration(PetRepository petRepository,
			OrderRepository orderRepository) {
		this.petRepository = petRepository;
		this.orderRepository = orderRepository;
	}

	@Bean
	public Query query() {
		return new Query(petRepository, orderRepository);
	}

	@Bean
	public Mutation mutation() {
		return new Mutation(petRepository, orderRepository);
	}

	@Bean
	public GraphQLScalarType dateTime() {
		return Scalars.dateTime;
	}
}
