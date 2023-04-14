package org.tap.enrollment.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.tap.enrollment.entity.account.Account;
import org.tap.enrollment.repository.account.AccountRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String[] SWAGGER = { "/v2/api-docs", "/swagger-resources/", "/swagger-ui.html", "/webjars/", "favicon.ico", "/error/" };
	
	@Autowired
	private AccountRepository accRepository;


	@Override
    public void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable()
    		.headers().frameOptions().disable()
            .and()
    		.authorizeRequests() 
    		.antMatchers("/h2/**").permitAll()
	    	.antMatchers(SWAGGER).permitAll()
	        .antMatchers("/enrollment/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
	        .antMatchers("/course-enrollment/**").hasAuthority("ROLE_ADMIN")
	        .antMatchers("/subject-enrollment/**").hasAuthority("ROLE_ADMIN")
	        .antMatchers("/account/**").hasAuthority("ROLE_ADMIN")
	        .anyRequest().authenticated();
	        
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		long totalRecord = accRepository.count();
		long id = 1;
		while(id<=totalRecord){
			Optional <Account> user = this.accRepository.findById(id);
	        if(user.isPresent()) {
	        	Account acc = user.get();
	        	
	        	auth.inMemoryAuthentication()
					.withUser(acc.getUsername())
					.password(passwordEncoder().encode(acc.getPassword()))
					.authorities("ROLE_"+ acc.getRole());
	        }
	        id++;
		}
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}