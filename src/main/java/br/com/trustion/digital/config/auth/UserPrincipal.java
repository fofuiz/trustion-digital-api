package br.com.trustion.digital.config.auth;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.trustion.digital.entities.User;

public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private final User user;
	
	public UserPrincipal(User user) {
        this.user = user;
    }
	
	public User getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

	@Override
    public String getPassword() {
        return user.getPassword();
    }

	//Setado no Token para utiliza-lo para controle de permissão
    @Override
    public String getUsername() {
        return user.getUuid().toString();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
