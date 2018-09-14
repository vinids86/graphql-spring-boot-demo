package br.com.saraiva.graphqldemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.saraiva.graphqldemo.repository.PetRepository;
import br.com.saraiva.graphqldemo.resolver.Mutation;
import br.com.saraiva.graphqldemo.resolver.Query;

/**
 * Created by sara on set, 2018
 */
@Configuration
public class GraphQLConfiguration {

	private final PetRepository petRepository;

	@Autowired
	public GraphQLConfiguration(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Bean
	public Query query() {
		return new Query(petRepository);
	}

	@Bean
	Mutation mutation() {
		return new Mutation(petRepository);
	}
}
