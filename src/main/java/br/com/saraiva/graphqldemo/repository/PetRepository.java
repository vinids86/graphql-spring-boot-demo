package br.com.saraiva.graphqldemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.saraiva.graphqldemo.model.Pet;

/**
 * Created by sara on set, 2018
 */
public interface PetRepository extends MongoRepository<Pet, String> {

	Pet findPetById(String id);
}
