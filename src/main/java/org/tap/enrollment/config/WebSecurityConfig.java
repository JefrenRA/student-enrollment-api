package org.tap.enrollment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
    protected void configure(HttpSecurity http) throws Exception { 
    	http.authorizeRequests()
	    	.antMatchers("/swagger-ui.html")
	        .permitAll()
	        .antMatchers("/h2/**")
	        .permitAll();
	        
    	
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

	    @Bean
	    public UserDetailsService userDetailsService() {
	    UserDetails user =
	         User.builder()
	            .username("user")
	            .password(passwordEncoder().encode("password"))
	            .roles("USER")
	            .build();
	    	
	    return new InMemoryUserDetailsManager(user);
	    }

	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	    }
	} 
