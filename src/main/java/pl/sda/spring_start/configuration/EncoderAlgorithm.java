package pl.sda.spring_start.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

                 // adnotacja determinująca specjalne znaczenie klasy
@Configuration   //
public class EncoderAlgorithm {

    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
