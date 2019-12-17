package br.com.trustion.digital.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.trustion.digital.entities.User;
import br.com.trustion.digital.models.dto.auth.AuthUserAndRolesAndAuthoritiesDTO;
import br.com.trustion.digital.services.IUserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/auth")
@Api(tags="Authorities", description="Serviços de usuários e permissões")
@RestController
@Slf4j
public class AuthController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping(value = "/authorities/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuthUserAndRolesAndAuthoritiesDTO> getAuthorities(@PathVariable String uuid){
		try {
			UUID uuidUser = UUID.fromString(uuid);
			
			User user = userService.findByUuid(uuidUser)
					.orElseThrow(() -> new UsernameNotFoundException("Error -> hasPermission for UUID: " + uuidUser));
			
			return ResponseEntity.ok(new AuthUserAndRolesAndAuthoritiesDTO(user));
		} catch (IllegalArgumentException ie) {
			log.error("Error method getAuthorities in class AuthController: ", ie);
			return ResponseEntity.badRequest().build();//400
		} 
		catch (Exception ex) {
			log.error("Error method getAuthorities in class AuthController: ", ex);
			return ResponseEntity.badRequest().build();//400
		}
	}
	
	@PreAuthorize("hasPermission(returnObject, {'p1_teste_delete', 'user_update', 'abcd_create', 'abcd_read', 'user_read'})")
	@DeleteMapping("/test/permission")
	public ResponseEntity<String> testAuthorities(){
		log.info("OK -> Permissão Testada");
		return ResponseEntity.ok("OK -> Permission OK");
	}
	
}
