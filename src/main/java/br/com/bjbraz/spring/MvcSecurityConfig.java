package br.com.bjbraz.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.bjbraz.service.UserService;

@Configuration
@EnableWebSecurity
public class MvcSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/resources/**").permitAll().antMatchers("/index")
//		.authenticated()
		.permitAll().antMatchers("/rest/**").permitAll();
//		.anyRequest().hasAnyRole("ADMIN")
//		.anyRequest().authenticated()
		//.antMatchers("/**", "/rest/listTodasTrancoes").authenticated().anyRequest().hasAnyRole("ADMIN")
//		.and().formLogin()
//		.loginPage("/login").usernameParameter("userName").passwordParameter("password")
//		.successHandler((req,res,auth)->{
//			res.sendRedirect("/dashboard");
//	      })
//		.failureHandler((req,res,exp)->{
//			String errMsg="";
//	         if(exp.getClass().isAssignableFrom(BadCredentialsException.class)){
//	            errMsg="Invalid e-mail or password.";
//	         }else{
//	            errMsg="Unknown error - "+exp.getMessage();
//	         }
//	         req.getSession().setAttribute("message", errMsg);
//	         res.sendRedirect("/login");
//		})
//		.permitAll()
//		.and()
//		.logout()
//		.logoutUrl("/logout")
//		.clearAuthentication(true)
//		.logoutSuccessUrl("/index")
//		.permitAll(); //.httpBasic() para utilizar autenticação do browser
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authProvider
	      = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(userDetailsService);
	    authProvider.setPasswordEncoder(encoder());
	    return authProvider;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder(11);
	}

}