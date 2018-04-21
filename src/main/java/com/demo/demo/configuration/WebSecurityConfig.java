package com.demo.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.sql.DataSource;

/**
 * @author alain.menchaca on 11/04/18.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/css/**", "/login").permitAll()
                .antMatchers("/fonts/**", "/login").permitAll()
                .antMatchers("/js/**", "/login").permitAll()

                .antMatchers("/user/**").hasRole("USERX")
                .and()
            .formLogin()
                .loginPage("/login")
                    .successForwardUrl("/user/dashboard")
                    .failureUrl("/login-error")
                .and()
            .logout()
					      .permitAll()
					      .and()
            .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

    @Bean
    @Override public UserDetailsService userDetailsService() {
        UserDetails user =
            User.withDefaultPasswordEncoder()
                .username("user")
                .password("pass")
                .roles("USERX")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}

