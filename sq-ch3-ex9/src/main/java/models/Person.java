package models;

import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;
    private final Parrot parrot;

    public Person(Parrot koko) {
        this.parrot = koko;
    }

    public String getName() {
        return name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", parrot=" + parrot +
                '}';
    }
}

