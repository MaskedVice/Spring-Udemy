package com.springudemy.springsecurity.springsecurity.security;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.springudemy.springsecurity.springsecurity.service.UserService;

@Configuration
public class DemoSecurityConfig {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider(UserService userService) {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userService);
		provider.setPasswordEncoder(bCryptPasswordEncoder());
		return provider;
		
	}


	@Bean
	public UserDetailsManager userDetailsManager(DataSource datasource){
		JdbcUserDetailsManager manager = new JdbcUserDetailsManager(datasource);

		manager.setUsersByUsernameQuery(
			"Select user_id,pw,active from members where user_id=?"
			);
		manager.setAuthoritiesByUsernameQuery(
			"Select user_id,role from roles where user_id=?"
			);
		return manager;
	}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers( "/css/**").permitAll()
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
        )
        .formLogin(form->
                form
                        .loginPage("/showMyLoginPage")
                        .loginProcessingUrl("/authenticate")
                        .permitAll()
                        
        ).logout(logout -> logout.permitAll()
        ).exceptionHandling(configurer->
                configurer.accessDeniedPage("/access-denied"));
        return http.build();
    }



    //     @Bean
//     public InMemoryUserDetailsManager userDetailsManager() {
//         UserDetails john = User.builder()
//                 .username("john")
//                 .password("{noop}test123")
//                 .roles("EMPLOYEE")
//                 .build();

//         UserDetails mary = User.builder()
//                 .username("mary")
//                 .password("{noop}test123")
//                 .roles("MANAGER","EMPLOYEE")
//                 .build();

//         UserDetails susan = User.builder()
//                 .username("susan")
//                 .password("{noop}test123")
//                 .roles("EMPLOYEE","MANAGER","ADMIN")
//                 .build();

//         return new InMemoryUserDetailsManager(john, mary, susan);
//     }
}
