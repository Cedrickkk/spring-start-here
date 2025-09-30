package org.spring.framework.sqch10ex4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.spring.framework.sqch10ex4.models.Country;
import org.spring.framework.sqch10ex4.services.CountryService;

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
    public ResponseEntity<List<Country>> countries() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Continent", "Asia")
                .body(countryService.findAll());
    }

    @GetMapping("/{country}")
    public ResponseEntity<Country> country(@PathVariable("country") String countryName) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(countryService.findByCountryName(countryName));
    }
}
