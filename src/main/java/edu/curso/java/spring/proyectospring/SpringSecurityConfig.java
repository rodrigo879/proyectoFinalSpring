package edu.curso.java.spring.proyectospring;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user1 = User.withDefaultPasswordEncoder().username("general").password("general1234").roles("USER")
				.build();

		UserDetails user2 = User.withDefaultPasswordEncoder().username("admin").password("admin1234")
				.roles("USER", "ADMIN").build();

		ArrayList<UserDetails> users = new ArrayList<UserDetails>();

		users.add(user1);
		users.add(user2);

		return new InMemoryUserDetailsManager(users);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests()
			.antMatchers("/api/**").authenticated()
			.antMatchers("/peliculas/**").authenticated()
			.antMatchers("/personajes/**").authenticated()
			.antMatchers("/generos/**").authenticated()
			.antMatchers("/**").permitAll().and()
			.formLogin(form -> {
				form.loginPage("/users/login");
				form.loginProcessingUrl("/validarUser");
				form.failureUrl("/login?error=true");
				form.defaultSuccessUrl("/peliculas");
			}).httpBasic().and().csrf().disable()
			.logout().logoutUrl("/logout").logoutSuccessUrl("/")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID");

		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
	}

}
