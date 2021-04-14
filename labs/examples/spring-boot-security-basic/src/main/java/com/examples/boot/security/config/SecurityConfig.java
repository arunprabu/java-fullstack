package com.examples.boot.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			// Disable CSRF check
			.csrf().disable()
			// Authorize Requests
			.authorizeRequests()
			// Allow root request w/o authentication
			.antMatchers("/").permitAll()
			// Allow Registration request w/o authentication			
			.antMatchers("/register/**").permitAll()
			.antMatchers("/users/**").permitAll()
			// Allow user endpoint for USER and ADMIN roles
			.antMatchers("/user/**").hasAnyRole("USER","ADMIN")
			// Allow manager endpoint for MANAGER and ADMIN roles			
			.antMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN")
			// Allow admin endpoint for ADMIN role
			.antMatchers("/admin/**").hasRole("ADMIN")
			// Authenticate rest all requests
			.anyRequest().authenticated()
				.and()
					// Enables Basic Authentication to access from REST Client
					.httpBasic()
				.and()
					// Enables Form Authentication to access from browser
					.formLogin();
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
