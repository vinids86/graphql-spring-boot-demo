package br.com.saraiva.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import br.com.saraiva.graphqldemo.model.Order;
import br.com.saraiva.graphqldemo.model.Pet;
import br.com.saraiva.graphqldemo.repository.OrderRepository;
import br.com.saraiva.graphqldemo.repository.PetRepository;

/**
 * Created by sara on set, 2018
 */
public class Mutation implements GraphQLMutationResolver {

	private final PetRepository petRepository;
	private final OrderRepository orderRepository;

	public Mutation(PetRepository petRepository, OrderRepository orderRepository) {
		this.petRepository = petRepository;
		this.orderRepository = orderRepository;
	}

	public Pet createPet(Pet input) {
		return petRepository.save(new Pet(input.getCategory(), input.getName(),
				input.getPhotoUrls(), input.getTags(), input.getStatus()));
	}

	public Pet updatePet(String id, Pet input) {

		return petRepository.findById(id).map(pet -> {
			pet.setCategory(input.getCategory());
			pet.setName(input.getName());
			pet.setPhotoUrls(input.getPhotoUrls());
			pet.setTags(input.getTags());
			pet.setStatus(input.getStatus());
			return pet;
		}).map(petRepository::save).orElse(null);
	}

	public Pet deletePet(String id) {

		return petRepository.findById(id).map(pet -> {
			petRepository.deleteById(id);
			return pet;
		}).orElse(null);
	}

	public Order createOrder(Order input) {
		return orderRepository.save(new Order(input.getPetId(), input.getQuantity(),
				input.getShipDate(), input.getStatus(), input.getComplete()));
	}
}
