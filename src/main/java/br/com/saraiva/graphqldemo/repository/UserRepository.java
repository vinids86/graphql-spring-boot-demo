package br.com.saraiva.graphqldemo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.saraiva.graphqldemo.model.User;

/**
 * Created by sara on set, 2018
 */
public interface UserRepository extends MongoRepository<User, String> {

	Optional<User> findUserByUsername(String username);
}
