package br.com.saraiva.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import br.com.saraiva.graphqldemo.model.Order;
import br.com.saraiva.graphqldemo.model.Pet;
import br.com.saraiva.graphqldemo.model.User;
import br.com.saraiva.graphqldemo.repository.OrderRepository;
import br.com.saraiva.graphqldemo.repository.PetRepository;
import br.com.saraiva.graphqldemo.repository.UserRepository;

/**
 * Created by sara on set, 2018
 */
public class Mutation implements GraphQLMutationResolver {

	private final PetRepository petRepository;
	private final OrderRepository orderRepository;
	private final UserRepository userRepository;

	public Mutation(PetRepository petRepository, OrderRepository orderRepository,
			UserRepository userRepository) {
		this.petRepository = petRepository;
		this.orderRepository = orderRepository;
		this.userRepository = userRepository;
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

	public User createUser(User input) {
		return userRepository.findUserByUsername(input.getUsername())
				.orElseGet(() -> userRepository.save(build("", input)));
	}

	public User updateUser(String id, User input) {
		return userRepository.findById(id)
				.filter(user -> !userRepository.findUserByUsername(input.getUsername())
						.isPresent())
				.map(user -> build(id, input)).map(userRepository::save).orElse(null);
	}

	private User build(String id, User input) {
		return User.Builder.anUser().withId(id).withUsername(input.getUsername())
				.withFirstName(input.getFirstName()).withLastName(input.getLastName())
				.withEmail(input.getEmail()).withPassword(input.getPassword())
				.withPhone(input.getPhone()).withUserStatus(input.getUserStatus())
				.build();
	}
}
