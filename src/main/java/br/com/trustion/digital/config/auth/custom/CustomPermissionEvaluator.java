package br.com.trustion.digital.config.auth.custom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.google.common.base.Splitter;

import br.com.trustion.digital.entities.Permission;
import br.com.trustion.digital.entities.Role;
import br.com.trustion.digital.entities.User;
import br.com.trustion.digital.services.IUserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomPermissionEvaluator implements PermissionEvaluator {

	@Autowired
	private IUserService userService;
	
	@Override
	public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
		
		if ((auth == null) || (permission == null)){
            return false;
        }
		
		try {
			List<String> permissionsValid = validPermissions(auth, permission);

			//Valid
			if(!permissionsValid.isEmpty()) {
				log.trace("Permission Valid for this method");
				return true;
			}else {
				log.trace("Permission Invalid for this method");
				return false;
			}
		} catch (Exception e) {
			log.error("Error in method hasPermission in class CustomPermissionEvaluator: ", e);
			return false;
		}
	}

	@Override
	public boolean hasPermission(Authentication auth, Serializable targetId, String targetType, Object permission) {
		return true;
	}
	
	private List<String> validPermissions(Authentication auth, Object permission) {
		log.debug("Begin - validating user permission in method validPermissions in class CustomPermissionEvaluator");
		
		UUID uuidUser = UUID.fromString(auth.getPrincipal().toString());
		
		List<String> permissionsMethod = Splitter.on(',')
				.trimResults()
				.omitEmptyStrings()
				.splitToList(permission.toString().substring(1, permission.toString().length()-1));
		
		User user = userService.findByUuid(uuidUser)
				.orElseThrow(() -> new UsernameNotFoundException("Error -> hasPermission for UUID: " + uuidUser));
		
		List<String> permissionsUser = new ArrayList<>();
		
		for (Role r : user.getRoles()) {
			for (Permission p : r.getPermissions()) {
				permissionsUser.add(p.getName());
			}
		}
		
		List<String> permissionsValid = permissionsMethod.stream()
				.filter(p -> permissionsUser.contains(p))
				.collect(Collectors.toList());
		
		log.debug("End - validating user permission in method validPermissions in class CustomPermissionEvaluator");
		return permissionsValid;
	}

}
