package com.empresa;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/listarcarrito","/vista_persona","/nuevapersona","/nuevoplato",
				"/editarpersona/**","/eliminarpersona/**","/listo","/menu","/","/css/**","/image/**","/js/**").permitAll()
		.antMatchers("/listacliente").hasAnyRole("ADMIN")
		.antMatchers("/listaplato").hasAnyRole("ADMIN")
		.antMatchers("/editarpersona/**").hasAnyRole("ADMIN")
		.and()
		.formLogin().loginPage("/login")
		.permitAll()
		.and()
		.logout().permitAll();

	}
	
	@Autowired
	public void configurerSecurityGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(passEncoder)
		.usersByUsernameQuery("SELECT username, password, enabled FROM users where username=?")
		.authoritiesByUsernameQuery("SELECT u.username, r.rol from roles r INNER JOIN users u on r.user_id=u.id where u.username=?");
	}

}
