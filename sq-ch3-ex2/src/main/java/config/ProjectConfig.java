package config;

import models.Parrot;
import models.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    public Person person() {
        Person person = new Person("Koko");
        person.setParrot(parrot());
        return person;
    }

    @Bean
    public Parrot parrot() {
        Parrot parrot = new Parrot();
        parrot.setName("Ella");
        return parrot;
    }
}
