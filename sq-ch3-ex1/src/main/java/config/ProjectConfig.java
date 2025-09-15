package config;

import models.Parrot;
import models.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    public Person person() {
        return new Person("Ella");
    }

    @Bean
    public Parrot parrot() {
        return new Parrot("Koko");
    }
}
