package org.spring.framework.sqch10ex4.services;

import org.springframework.stereotype.Service;
import org.spring.framework.sqch10ex4.models.Country;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {
    private List<Country> countries = new ArrayList<>(List.of(
            Country.of("Japan", 123_103_479),
            Country.of("Singapore", 5_870_750),
            Country.of("Philippines", 112_729_484)));

    public List<Country> findAll() {
        return countries;
    }

    public Country findByCountryName(String name) {
        for (Country country : countries) {
            if (country.getName().equalsIgnoreCase(name)) {
                return country;
            }
        }
        return null;
    }
}
