package seguros.api.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class MvcSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeRequests()
				.antMatchers("/", "/error", "/login", "/index", "/resources","/rest/eth/login").permitAll()
				.and()
				.formLogin()
				.loginPage("/login")
				.successForwardUrl("/proccess")
				.usernameParameter("usuario") // default is username
				.passwordParameter("senha")
				.permitAll()
				.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.permitAll()
		;
		
		http
				.authorizeRequests()
				.antMatchers("/error").authenticated()
				.antMatchers("/home").hasRole("admin")
				.antMatchers("/zscore").hasRole("zscore")
				.antMatchers("/proNatura").hasRole("pronatura")
				.antMatchers("/home_zscore.html").hasRole("zscore")
				.antMatchers("/home.html").hasRole("admin")
				.antMatchers("/home_pronatura.jsp").hasRole("pronatura")
				.antMatchers("/home_pronatura.html").hasRole("pronatura")
				;

	}

	@Autowired

	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth
				.inMemoryAuthentication()
				.withUser("admin").password("admin").roles("admin").and()
				.withUser("pronatura").password("pronatura").roles("pronatura").and()
				.withUser("zscore").password("zscore").roles("zscore");

	}

}