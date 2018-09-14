package br.com.saraiva.graphqldemo.resolver;

import br.com.saraiva.graphqldemo.model.Pet;
import br.com.saraiva.graphqldemo.model.PetCategory;
import br.com.saraiva.graphqldemo.model.Status;
import br.com.saraiva.graphqldemo.repository.PetRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.ArrayList;

/**
 * Created by sara on set, 2018
 */
public class Query implements GraphQLQueryResolver {

	private final PetRepository petRepository;

	public Query(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	public Pet findPetById() {
		final Pet pet = petRepository.findPetById("1");
		return new Pet("1", new PetCategory("1", "Animal"), "Doggie", new ArrayList<>(),
				new ArrayList<>(), Status.AVAILABLE);
	}
}
