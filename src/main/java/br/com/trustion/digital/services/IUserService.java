package br.com.trustion.digital.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.trustion.digital.entities.User;

public interface IUserService {
	
	public List<User> findAll();
	
	public User save(User user);

	public User findByName(String name);
	
	public User findByLogin(String login);
	
	public Optional<User> findByUuid(UUID uuid);
	
}
