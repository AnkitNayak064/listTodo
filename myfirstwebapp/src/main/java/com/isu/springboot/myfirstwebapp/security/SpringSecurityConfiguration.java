package com.isu.springboot.myfirstwebapp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		UserDetails userDetails1 = createNewUser("ankit", "ankitnayak");
		UserDetails userDetails2 = createNewUser("kaby", "kaibalyaprasadnath");
		UserDetails userDetails3 = createNewUser("sumanta", "sumantasahoo");
		UserDetails userDetails4 = createNewUser("ankita", "ankitapradhan");
		return new InMemoryUserDetailsManager(userDetails1,userDetails2,userDetails3,userDetails4);
	}

	private UserDetails createNewUser(String username, String password) {
		UserDetails userDetails = User.builder().username(username).password(passwordEncoder().encode(password)).roles("USER")
				.build();
		return userDetails;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChange(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(
			auth -> auth.anyRequest().authenticated());	
		http.formLogin(withDefaults());
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
		return http.build();
	}
		
	

}
