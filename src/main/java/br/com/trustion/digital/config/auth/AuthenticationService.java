package br.com.trustion.digital.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.trustion.digital.entities.User;
import br.com.trustion.digital.repositories.IUserRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthenticationService implements UserDetailsService{

	@Autowired
	IUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) {
		
		try {
			User user = userRepository
					.findByLogin(login)
					.orElseThrow(() -> new UsernameNotFoundException("User with login " + login + " not founded"));
			return new UserPrincipal(user);
			
		} catch (UsernameNotFoundException e) {
			log.error("Error Username not found method loadUserByUsername in class AuthenticationService: ", e);
		} catch (Exception e) {
			log.error("Error method loadUserByUsername in class AuthenticationService: ", e);
		}
		
		return null;
	}

}
