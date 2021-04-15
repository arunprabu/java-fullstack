package com.examples.spring.cloud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	private ClientDetailsService clientDetailsService;
 
	@Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
        .withUser("admin").password("{noop}admin123").roles("ADMIN","USER").and()
        .withUser("manager").password("{noop}manager123").roles("MANAGER","USER").and()
        .withUser("user").password("{noop}pass123").roles("USER");
    }
	
 
    @Override
    @Order(Ordered.HIGHEST_PRECEDENCE)
    protected void configure(HttpSecurity http) throws Exception {
		http
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/oauth/token").permitAll()
			.antMatchers("/check_token").permitAll()
			.anyRequest().authenticated()
	  	.and()
	  		.httpBasic()
	  			.realmName("CRM_REALM");
    }
 
	
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
 
	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}
 
/*	@Bean
	@Autowired
	public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore){
		TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
		handler.setTokenStore(tokenStore);
		handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
		handler.setClientDetailsService(clientDetailsService);
		return handler;
	}*/
	
	@Bean
	@Autowired
	public ApprovalStore approvalStore(TokenStore tokenStore) throws Exception {
		TokenApprovalStore store = new TokenApprovalStore();
		store.setTokenStore(tokenStore);
		return store;
	}

}