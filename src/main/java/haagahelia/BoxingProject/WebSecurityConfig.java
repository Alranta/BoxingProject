package haagahelia.BoxingProject;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //CONFIGURATION FOR SECURITY
@EnableMethodSecurity(securedEnabled = true) // ENABLE METHODSECURITY FOR CONTROLLER!
public class WebSecurityConfig {

	@Autowired 
	private UserDetailsService userDetailsService; // DETAIL SERVICE FOR USERS
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http
		
		.authorizeHttpRequests()
			.requestMatchers("/css/**").permitAll()
			.requestMatchers("/", "/index").permitAll()
			.requestMatchers(toH2Console()).permitAll()
			.anyRequest().authenticated()
			.and()
			 .csrf().ignoringRequestMatchers(toH2Console())
			  .and()
			  .headers().frameOptions().disable()
			  .and()
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/indexadmin", true)
			.permitAll()
			.and()
		.logout()
			.permitAll()
			.and()
			.httpBasic();
		return http.build();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
}
}
