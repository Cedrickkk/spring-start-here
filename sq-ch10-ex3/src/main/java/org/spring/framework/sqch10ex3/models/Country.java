package org.spring.framework.sqch10ex3.models;

public class Country {
    private String name;
    private int population;

    private Country() {
    }

    public static Country of(String name, int population) {
        Country country = new Country();
        country.setName(name);
        country.setPopulation(population);
        return country;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    private void setPopulation(int population) {
        this.population = population;
    }
}
