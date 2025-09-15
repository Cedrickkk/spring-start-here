package models;

public class Parrot {
    private String name;

    public Parrot() {
        System.out.println("Parrot created.");
    }

    public Parrot(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
