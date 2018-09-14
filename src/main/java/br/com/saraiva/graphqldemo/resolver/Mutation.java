package br.com.saraiva.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import br.com.saraiva.graphqldemo.model.Pet;
import br.com.saraiva.graphqldemo.repository.PetRepository;

/**
 * Created by sara on set, 2018
 */
public class Mutation implements GraphQLMutationResolver {

	private final PetRepository petRespository;

	public Mutation(PetRepository petRepository) {
		this.petRespository = petRepository;
	}

	public Pet createPet(Pet input) {
		return petRespository.save(new Pet(input.getCategory(), input.getName(),
				input.getPhotoUrls(), input.getTags(), input.getStatus()));
	}

	public Pet updatePet(String id, Pet input) {
		final Pet pet = petRespository.findPetById(id);
		pet.setCategory(input.getCategory());
		pet.setName(input.getName());
		pet.setPhotoUrls(input.getPhotoUrls());
		pet.setTags(input.getTags());
		pet.setStatus(input.getStatus());
		return petRespository.save(pet);
	}

	public Pet deletePet(String id) {
		final Pet pet = petRespository.findPetById(id);
		petRespository.deleteById(id);
		return pet;
	}

}
