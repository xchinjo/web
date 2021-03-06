package br.com.bjbraz.spring;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.bjbraz.domain.User;

public class MyUserPrincipal  implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1983254493831734958L;
	private User user;
 
    public MyUserPrincipal(User user) {
        this.user = user;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> retorno = new ArrayList<GrantedAuthority>();
		retorno.add(new SimpleGrantedAuthority("ADMIN"));//TODO ADD NA BASE DE DADOS
		return retorno;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getNome();
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
