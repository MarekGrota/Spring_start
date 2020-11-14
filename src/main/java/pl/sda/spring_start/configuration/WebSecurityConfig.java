package pl.sda.spring_start.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity      // aktywacja metod zabezpieczeń z klasy WebSecurityconfigurerAdapter
@Configuration          // konfiguracja zabezpieczeń aplikacji
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // http security - determinuje które adresy będą wymagały określonych uprawnień
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()    // uwwierzytelniaj poniższe żądania http
                .antMatchers("/addPost").hasAnyAuthority("ROLE_USER")
                .antMatchers("/posts&**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
                .anyRequest().permitAll()   // każde inne żądanie nie uwierzytelniaj
                .and()
                    .formLogin()            // defaultowy formularz logowania
                .and()
                    .httpBasic();
    }
}
