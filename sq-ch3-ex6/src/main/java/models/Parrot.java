package models;

import org.springframework.stereotype.Component;

@Component
public class Parrot {
    private String name = "Koko";

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + name + '\'' +
                '}';
    }
}
