package org.tap.enrollment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final String[] SWAGGER = { "/v2/api-docs", "/swagger-resources/", "/swagger-ui.html", "/webjars/", "favicon.ico", "/error/" };
	
	@Override
    public void configure(HttpSecurity http) throws Exception { 
    	http.authorizeRequests()
	    	.antMatchers(SWAGGER).permitAll()
	        .antMatchers("/h2/**").permitAll()
	        .antMatchers("/enrollment/**").hasRole("USER")
	        .antMatchers("/course-enrollment/**").hasRole("ADMIN")
	        .antMatchers("/subject-enrollment/**").hasRole("ADMIN")
	        .anyRequest().authenticated().and().formLogin();
    	
    		http.csrf().disable();
    		http.headers().frameOptions().disable();
    }

}