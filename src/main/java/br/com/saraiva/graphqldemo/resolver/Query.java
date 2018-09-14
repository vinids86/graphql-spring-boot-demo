package br.com.saraiva.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import br.com.saraiva.graphqldemo.model.Pet;
import br.com.saraiva.graphqldemo.repository.PetRepository;

/**
 * Created by sara on set, 2018
 */
public class Query implements GraphQLQueryResolver {

	private final PetRepository petRepository;

	public Query(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	public Pet findPetById(String id) {
		return petRepository.findPetById(id);
	}
}
