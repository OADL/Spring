package com.oadl.spring.config;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authProvider() {
        return new AuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                String name = authentication.getName();
                String password = authentication.getCredentials().toString();
                UserDetails principal = userDetailsService.loadUserByUsername(name);
                if(!password.equals(principal.getPassword())) return null;
                return new UsernamePasswordAuthenticationToken(principal, password, principal.getAuthorities());
            }

            @Override
            public boolean supports(Class<?> aClass) {
                return aClass.equals(UsernamePasswordAuthenticationToken.class);
            }
        };
    }

    @Bean
    public OncePerRequestFilter clearSecurityContextFilter() {
        return new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
                throws ServletException, IOException {
                SecurityContextHolder.clearContext();
                filterChain.doFilter(request, response);
            }
        };
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authenticationProvider(authProvider())
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic(Customizer.withDefaults())
            .addFilterAfter(clearSecurityContextFilter(), SecurityContextPersistenceFilter.class);
    }

//If we're not using WebSecurityConfigurerAdapter
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//            .authenticationProvider(authProvider())
//            .authorizeHttpRequests(request -> request
//                .anyRequest()
//                .authenticated())
//            .httpBasic(Customizer.withDefaults())
//            .addFilterAfter(clearSecurityContextFilter(), SecurityContextPersistenceFilter.class)
//            .build();
//    }

}
