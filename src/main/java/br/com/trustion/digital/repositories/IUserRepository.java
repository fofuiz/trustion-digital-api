package br.com.trustion.digital.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.trustion.digital.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByName(String name);
	
	public Optional<User> findByLogin(String login);
	
	public Optional<User> findByUuid(UUID uuid);
	
}
