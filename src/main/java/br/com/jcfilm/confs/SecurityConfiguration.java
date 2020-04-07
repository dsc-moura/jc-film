package br.com.jcfilm.confs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.jcfilm.interfaces.IUsuarioQueryService;


@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	IUsuarioQueryService IUsuario;	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)	throws Exception {
		auth.userDetailsService(IUsuario)
			.passwordEncoder(new BCryptPasswordEncoder());
	}	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/index").permitAll()
		.failureUrl("/index?error=true").defaultSuccessUrl("/home", true).permitAll()
		.and().rememberMe().userDetailsService(IUsuario)
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}	
	
}

