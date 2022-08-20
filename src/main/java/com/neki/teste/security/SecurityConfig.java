package com.neki.teste.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.neki.teste.services.UserDetailsServiceImplService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImplService userDetailsServiceImplService;

	@Autowired
	JwtUtil jwtUtil;

	private static final String[] AUTH_WHITELIST = { "/user/**", "/login/**" };

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//		http.authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll().anyRequest().authenticated();
//		http.addFilterBefore(new JWTAutheticationFilter(authenticationManager(), jwtUtil),
//				UsernamePasswordAuthenticationFilter.class);
//		http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
		http.authorizeRequests()
		.antMatchers(HttpMethod.POST, AUTH_WHITELIST).permitAll().antMatchers(HttpMethod.GET,
				"/swagger-ui/*", "/swagger-ui.html", "/webjars/", "/v2/api-docs/", "/swagger-resources/").permitAll()
				.anyRequest().authenticated();
		http.addFilter(new JWTAutheticationFilter(authenticationManager(), jwtUtil));
		http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImplService).passwordEncoder(passwordEncoder());
	}

//	@Bean
//	public WebMvcConfigurer getCorsConfiguration() {
//		return new WebMvcConfigurer() {
//
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedOrigins("http://localhost:3000/")
//						.allowedMethods("GET", "POST", "PUT", "DELETE").allowedHeaders("*").exposedHeaders("*");
//			}
//		};
//	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.cors().and().csrf().disable().authorizeRequests()
//				.antMatchers(HttpMethod.GET, "/pedidos", "/clientes", "/enderecos", "/funcionarios", "/categorias",
//						"/produtos")
//				.permitAll()
//				.antMatchers(HttpMethod.DELETE, "/pedidos", "/clientes", "/enderecos", "/funcionarios", "/categorias",
//						"/produtos")
//				.permitAll()
//				.antMatchers(HttpMethod.POST, "/pedidos", "/clientes", "/enderecos", "/funcionarios", "/categorias",
//						"/produtos")
//				.permitAll()
//				.antMatchers(HttpMethod.PUT, "/pedidos", "/clientes", "/enderecos", "/funcionarios", "/categorias",
//						"/produtos")
//				.permitAll().anyRequest().authenticated().and().httpBasic().and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//	}

//	@Bean
//	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	    http
//	         .csrf().disable()
//	         .authorizeRequests().anyRequest().authenticated()
//	         .and()
//	         .httpBasic();
//
//	    return http.build();
//	  }
//
//	  @Bean
//	  public InMemoryUserDetailsManager userDetailsService() {
//	    UserDetails user = User
//	        .withUsername("user")
//	        .password("{noop}password")
//	        .roles("USER")
//	        .build();
//	    return new InMemoryUserDetailsManager(user);
//	  }
}
