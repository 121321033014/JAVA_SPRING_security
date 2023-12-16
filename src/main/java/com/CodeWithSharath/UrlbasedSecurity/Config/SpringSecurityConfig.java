package com.CodeWithSharath.UrlbasedSecurity.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

public class SpringSecurityConfig {
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Namjoon").password("Namjoon@BTS").roles("admin");
        auth.inMemoryAuthentication().withUser("Jungkook").password("Jungkook@BTS").roles("user");

    }
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/codewithsharath/login/**")
                .hasAnyRole("admin")
                .anyRequest()
                .fullyAuthenticated()
                .and()
                .httpBasic();
    }
    @Bean
    public static NoOpPasswordEncoder passwordEncoder(){
      return (NoOpPasswordEncoder)  NoOpPasswordEncoder.getInstance();
    }
}
