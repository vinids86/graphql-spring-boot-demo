package br.com.saraiva.graphqldemo.resolver;

import java.util.ArrayList;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import br.com.saraiva.graphqldemo.Pet;
import br.com.saraiva.graphqldemo.model.PetCategory;
import br.com.saraiva.graphqldemo.model.Status;

/**
 * Created by sara on set, 2018
 */
public class Mutation implements GraphQLMutationResolver {
	public Pet createPet() {
		return new Pet("1", new PetCategory("1", "Animal"), "Doggie", new ArrayList<>(),
				new ArrayList<>(), Status.AVAILABLE);
	}
}
