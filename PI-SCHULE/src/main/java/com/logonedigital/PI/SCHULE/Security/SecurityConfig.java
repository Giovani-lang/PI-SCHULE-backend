package com.logonedigital.PI.SCHULE.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private static final String[] ENS_SECURE_URLs= {
            "/api/v1/ficheDePresence/**",
            "/api/v1/notes/**",
            "/api/v1/releves/**"
    };
    private static final String[] ADMIN_SECURE_URLs = {
            "/api/v1/emploisDuTemps/**",
            "/api/v1/pensionsScolaire/**"
    };
    private static final String[] ETU_UN_SECURE_URLs = {
            "/api/v1/ficheDePresence",
            "/api/v1/notes/",
            "/api/v1/releves/",
            "/api/v1/emploisDuTemps/",
            "/api/v1/pensionsScolaire/"
    };
    private static final String[] UN_SECURE_URLs ={
            "/api/v1/auth",
            "/api/v1/enseignants",
            "/api/v1/administrations",
            "/api/v1/etudiants"
    };

    @Bean
    public PasswordEncoder encoder (){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public org.springframework.security.core.userdetails.UserDetailsService userDetailsService(){
        return new UserDetailsService();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setPasswordEncoder(encoder());
        authenticationProvider.setUserDetailsService(userDetailsService());

        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
         http.authorizeHttpRequests(auth-> {
             auth.requestMatchers(ENS_SECURE_URLs).hasAuthority("ENSEIGNANT");
             auth.requestMatchers(ADMIN_SECURE_URLs).hasAuthority("ADMIN");
             auth.requestMatchers(HttpMethod.GET,ENS_SECURE_URLs).hasAuthority("ETUDIANT");
             auth.requestMatchers(UN_SECURE_URLs).authenticated();
             auth.anyRequest().permitAll();
        });

        http.csrf(csrf -> csrf.disable())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS))
                .httpBasic(it -> {});
        return http.build();
    }
}
