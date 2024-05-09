package minkostplan.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests

                                .requestMatchers(
                                        new OrRequestMatcher(
                                                new AntPathRequestMatcher("/login"),
                                                new AntPathRequestMatcher("/UserCreation"),
                                                new AntPathRequestMatcher("/**/*.css"),
                                                new AntPathRequestMatcher("/**/*.jpg"),
                                                new AntPathRequestMatcher("/**/*.png"),
                                                new AntPathRequestMatcher("/**/*.js")
                                        )
                                ).permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .defaultSuccessUrl("/HomeSite")
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/LoginPage?logout")
                );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        List<UserDetails> userdetailslist = new ArrayList<>();

        // Hardcoded user 1
        UserDetails user1 = User.withUsername("user1")
        .passwordEncoder(passwordEncoder()::encode)
        .password("password1")
        .build();
        userdetailslist.add(user1);

        // Hardcoded user 2
        UserDetails user2 = User.withUsername("user2")
                .passwordEncoder(passwordEncoder()::encode)
                .password("password2")
                .build();
        userdetailslist.add(user2);

        return new InMemoryUserDetailsManager(userdetailslist);
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


 
}