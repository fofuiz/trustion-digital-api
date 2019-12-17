package br.com.trustion.digital.models.dto.auth;

import br.com.trustion.digital.entities.Permission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthPermissionsDTO {

	private String name;
	
	public AuthPermissionsDTO(Permission permission) {
		this.name = permission.getName();
	}
	
}
