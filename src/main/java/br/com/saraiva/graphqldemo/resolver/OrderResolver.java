package br.com.saraiva.graphqldemo.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import br.com.saraiva.graphqldemo.model.Order;
import br.com.saraiva.graphqldemo.model.Pet;
import br.com.saraiva.graphqldemo.repository.PetRepository;

/**
 * Created by sara on set, 2018
 */
@Component
public class OrderResolver implements GraphQLResolver<Order> {

	private final PetRepository petRepository;

	@Autowired
	public OrderResolver(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	public Pet pet(Order order) {
		return petRepository.findById(order.getPetId()).orElse(null);
	}
}
