package bookshelf.appConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import bookshelf.service.UserService;


@Configuration
@EnableWebSecurity
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {

	 @Autowired
	 private UserService userService;
	
	 @Autowired
	 private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	 

	
	// use jdbc authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		auth.authenticationProvider(authenticationProvider());
		
		
		
	}
	
	// authentication in memory method
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// add users in memory auth
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("beg").password("test123").roles("USER"));
		
		auth.inMemoryAuthentication()
			.withUser(users.username("deniz").password("deniz123").roles("USER", "ADMIN"));
		
		auth.inMemoryAuthentication()
			.withUser(users.username("selin").password("selin123").roles("USER", "MANAGER"));
		
		
	}*/

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// deprected ald - approach
		http.authorizeRequests()
		.antMatchers("/").hasRole("USER")
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/systems/**").hasRole("ADMIN")
	.and()
		.formLogin()
			.loginPage("/showLoginPage")
			.loginProcessingUrl("/authenticateTheUser")
			.permitAll()
		.and()
			.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied");

		/*http.authorizeRequests()
		.antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/systems/**").hasRole("ADMIN")
		.and()
		.formLogin()
			.loginPage("/showMyLoginPage")
			.loginProcessingUrl("/authenticateTheUser")
			.successHandler(customAuthenticationSuccessHandler)
			.permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied");
		*/
		
		
		
	}

	
	// b-crypt bean definition
	
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	
	}

	// Authentiocation provider definition
	
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
	
	
}
	

