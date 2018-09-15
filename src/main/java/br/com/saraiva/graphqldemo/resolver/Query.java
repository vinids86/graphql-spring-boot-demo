package br.com.saraiva.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import br.com.saraiva.graphqldemo.model.Order;
import br.com.saraiva.graphqldemo.model.Pet;
import br.com.saraiva.graphqldemo.repository.OrderRepository;
import br.com.saraiva.graphqldemo.repository.PetRepository;

/**
 * Created by sara on set, 2018
 */
public class Query implements GraphQLQueryResolver {

	private final PetRepository petRepository;
	private final OrderRepository orderRepository;

	public Query(PetRepository petRepository, OrderRepository orderRepository) {
		this.petRepository = petRepository;
		this.orderRepository = orderRepository;
	}

	public Pet findPetById(String id) {
		return petRepository.findById(id).orElse(null);
	}

	public Order findOrderById(String id) {
		return orderRepository.findById(id).orElse(null);
	}
}
