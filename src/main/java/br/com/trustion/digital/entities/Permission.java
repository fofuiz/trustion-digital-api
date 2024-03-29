package br.com.trustion.digital.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity(name = "PermissionEntity")
@Table(name = "tbl_permission")
public class Permission implements Serializable {
	
	@Transient
	private static final long serialVersionUID = 627952684503591931L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long permissionId;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(mappedBy = "permissions", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<Role> roles;
	
	@Override
    public int hashCode() {
        if (permissionId != null) {
            return permissionId.hashCode();
        } else if (name != null) {
            return name.hashCode();
        }
        return 0;
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || !(another instanceof Permission))
            return false;
        Permission anotherPermission = (Permission) another;
        return (anotherPermission.permissionId != null && (anotherPermission.permissionId == this.permissionId))
                || (anotherPermission.permissionId == null && anotherPermission.name != null && (anotherPermission.name.equals(this.name)));
    }

	public Permission(String name) {
		this.name = name;
	}

}
