package br.com.bjbraz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.bjbraz.domain.User;
import br.com.bjbraz.repo.UserRepository;
import br.com.bjbraz.spring.MyUserPrincipal;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
    private UserRepository userRepository;
 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
	}


	public Optional<User> findByUserName(String userName) {
		return userRepository.findByName(userName);
	}

}
