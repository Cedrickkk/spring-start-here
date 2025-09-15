package models;

import org.springframework.stereotype.Component;

@Component
public class Parrot {
    private String name = "Koko";
    private final Person person;

    public Parrot(Person person) {
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + name + '\'' +
                ", person=" + person +
                '}';
    }
}
