package config;

import models.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean(name = "koko")
    @Primary
    public Parrot parrot1() {
        Parrot koko = new Parrot();
        koko.setName("Koko");
        return koko;
    }

    @Bean(value = "miki")
    public Parrot parrot2() {
        Parrot miki = new Parrot();
        miki.setName("Miki");
        return miki;
    }

    @Bean("riki")
    public Parrot parrot3() {
        Parrot riki = new Parrot();
        riki.setName("Riki");
        return riki;
    }
}
