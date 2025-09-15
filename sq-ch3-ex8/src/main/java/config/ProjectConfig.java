package config;

import models.Parrot;
import models.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    public Parrot koko() {
        return new Parrot("Koko");
    }

    @Bean
    public Parrot miki() {
        return new Parrot("Miki");
    }

    @Bean
    public Person person(@Qualifier("koko") Parrot parrot) {
        Person person = new Person();
        person.setName("Ella");
        person.setParrot(parrot);
        return person;
    }
}
