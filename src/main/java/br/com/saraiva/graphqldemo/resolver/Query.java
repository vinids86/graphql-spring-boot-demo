package br.com.saraiva.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import br.com.saraiva.graphqldemo.model.Order;
import br.com.saraiva.graphqldemo.model.Pet;
import br.com.saraiva.graphqldemo.model.User;
import br.com.saraiva.graphqldemo.repository.OrderRepository;
import br.com.saraiva.graphqldemo.repository.PetRepository;
import br.com.saraiva.graphqldemo.repository.UserRepository;

/**
 * Created by sara on set, 2018
 */
public class Query implements GraphQLQueryResolver {

	private final PetRepository petRepository;
	private final OrderRepository orderRepository;
	private final UserRepository userRepository;

	public Query(PetRepository petRepository, OrderRepository orderRepository,
			UserRepository userRepository) {
		this.petRepository = petRepository;
		this.orderRepository = orderRepository;
		this.userRepository = userRepository;
	}

	public Pet findPetById(String id) {
		return petRepository.findById(id).orElse(null);
	}

	public Order findOrderById(String id) {
		return orderRepository.findById(id).orElse(null);
	}

	public User findUserByUsername(String username) {
		return userRepository.findUserByUsername(username).orElse(null);
	}
}
