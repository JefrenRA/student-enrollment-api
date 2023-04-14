package org.tap.enrollment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String[] SWAGGER = { "/v2/api-docs", "/swagger-resources/", "/swagger-ui.html", "/webjars/",
			"favicon.ico", "/error/" };

//	@Autowired
//	private AccountRepository accRepository;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
				.authorizeRequests()
				.antMatchers("/h2/**").permitAll()
				.antMatchers(SWAGGER).permitAll()
				.antMatchers("/course-enrollment/**").hasRole("ADMIN")
				.antMatchers("/subject-enrollment/**").hasRole("ADMIN")
				.antMatchers("/account/**").hasRole("ADMIN")
				.anyRequest().authenticated();

	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		long totalRecord = accRepository.count();
//		long id = 1;
//		while (id <= totalRecord) {
//			Optional<Account> user = this.accRepository.findById(id);
//			if (user.isPresent()) {
//				Account acc = user.get();
//
//				auth.inMemoryAuthentication().withUser(acc.getUsername())
//						.password(passwordEncoder().encode(acc.getPassword())).authorities("ROLE_" + acc.getRole());
//			}
//			id++;
//		}
//	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}