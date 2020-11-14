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
                    .csrf().disable()
                    .formLogin() .loginPage("/login")           // dadres dla żądania typu GET wyświetlający stronę logowania
                    .usernameParameter("email")                 // nazwa pola w które wprowadzamy email (th:name)
                    .passwordParameter("password")              // nazwa pola w które wprowadzamy password (th:name)
                    .loginProcessingUrl("/login_process")       // adres na który wysyłamy dane logowania (th:action)
                    .failureUrl("/login&error=true")                 // adres na który jesteśmy przekierowani po błędnym logowaniu
                    .defaultSuccessUrl("/")                     // po poprawnym logowaniu przekierowanie na adres /
                .and()
                    .logout()                                   // wylogowanie
                    .logoutUrl("/logout")                       // adres do wylogowania
                    .logoutSuccessUrl("/");                     // przekierowanie po wylogowaniu
    }
}
