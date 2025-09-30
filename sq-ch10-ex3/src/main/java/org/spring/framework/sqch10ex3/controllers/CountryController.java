package org.spring.framework.sqch10ex3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.spring.framework.sqch10ex3.models.Country;
import org.spring.framework.sqch10ex3.services.CountryService;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> countries() {
        return countryService.findAll();
    }

    @GetMapping("/{country}")
    public Country country(@PathVariable("country") String name) {
        for (Country _country : countryService.findAll()) {
            if (_country.getName().equalsIgnoreCase(name)) {
                return _country;
            }
        }
        return null;
    }
}
