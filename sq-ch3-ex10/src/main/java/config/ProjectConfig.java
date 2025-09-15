package config;

import models.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"models"})
public class ProjectConfig {
    @Bean
    public Parrot miki() {
        return new Parrot("Miki");
    }

    @Bean
    public Parrot koko() {
        return new Parrot("Koko");
    }
}
