package com.furxall.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(auth ->
			auth.requestMatchers("/card/**").authenticated()
			.anyRequest().permitAll())
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
	/*
	@Bean
	UserDetailsService userDetailService (DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}
	
	@Bean
	InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		
		UserDetails admin = User.withUsername("admin")
				.password("{noop}to_be_encoded")
				.authorities("admin").build();
		
		UserDetails user = User.withUsername("user")
				.password("{noop}to_be_encoded")
				.authorities("user").build();
		
		return new InMemoryUserDetailsManager(admin, user);
		
	}
	
	
	PasswordEncoder passwordEncoder() {
		return new NoOpPasswordEncoder.getInstance();
	}
	*/
	
}
