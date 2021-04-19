package com.gortiz.AppCinema.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.gortiz.AppCinema.Security.Service.UserDetailsServiceImpl;
import com.gortiz.AppCinema.util.CustomAccessDeniedHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true )
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
		
	}

	BCryptPasswordEncoder bCryptPasswordEncoder;
    //encriptador de contraseñas	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    AccessDeniedHandler accessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
			
		http.authorizeRequests()
        .antMatchers("/css/**", "/js/**", "/img/**", "/fragments", "/forbidden", "/login")
        .permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginProcessingUrl("/signin")
        .loginPage("/login").permitAll()
        .defaultSuccessUrl("/success")
        .usernameParameter("nombreUsuario")
        .passwordParameter("password")
        .and()
        .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
        .and()
        .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/login?logout").permitAll()
        .deleteCookies("JSESSIONID");
        
	}

}
