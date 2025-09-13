package models;

public class Parrot {
    private String name;
    private String color;

    public Parrot(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
