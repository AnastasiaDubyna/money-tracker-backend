//package com.example.backend.config;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http
////                // by default uses a Bean by the name of corsConfigurationSource
////                .cors(withDefaults());
//        http
//                .authorizeRequests()
//                    .anyRequest().authenticated()
//                    .and()
//                .httpBasic();
//
//    }
//}