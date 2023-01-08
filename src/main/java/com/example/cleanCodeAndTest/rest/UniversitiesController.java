package com.example.cleanCodeAndTest.rest;

import com.example.cleanCodeAndTest.rest.vm.UniversityVM;
import com.example.cleanCodeAndTest.service.interfaces.UniversityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/university")
public class UniversitiesController {

    private final UniversityService universityService;

    public UniversitiesController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping(value = "/get-universities/{country}")
    public ResponseEntity<Object> getUniversities(@PathVariable(name = "country") String country){
        List<UniversityVM> countryUniversity = universityService.getCountryUniversity(country);
        return ResponseEntity
            .ok()
            .body(countryUniversity);
    }
}
