package org.tap.enrollment.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    private CustomAccessDeniedHandler customAccessDeniedHandler;
	
	@Autowired
	private AccountRepository accRepository;


	@Override
    public void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
	    	.antMatchers(SWAGGER).permitAll()
	        .antMatchers("/h2/**").permitAll()
	        .antMatchers("/enrollment/**").hasRole("USER")
	        .antMatchers("/course-enrollment/**").hasRole("ADMIN")
	        .antMatchers("/subject-enrollment/**").hasRole("ADMIN")
	        .antMatchers("/account/**").hasRole("ADMIN")
	        .anyRequest().authenticated().and()
	        .formLogin().permitAll()
            .and()
            .logout().logoutUrl("/").permitAll()
            .and()
            .exceptionHandling()
            .accessDeniedHandler(customAccessDeniedHandler);

    		http.csrf().disable();
    		http.headers().frameOptions().disable();
    }

	@Override
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager inMemoryUser = new InMemoryUserDetailsManager();
		
		long totalRecord = accRepository.count();
		long id = 1;
		while(id<=totalRecord){
			Optional <Account> user = this.accRepository.findById(id);
	        if(user.isPresent()) {
	        	Account acc = user.get();
	        	
	        	UserDetails userDetails =  User.withUsername(acc.getUsername())
									.password(passwordEncoder().encode(acc.getPassword()))
									.roles(acc.getRole()).build();
	        	
	        	inMemoryUser.createUser(userDetails);
	        }
	        id++;
		}
		
	    return inMemoryUser;
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}