package com.example.cleanCodeAndTest.service.impl;

import com.example.cleanCodeAndTest.client.UniversityClient;
import com.example.cleanCodeAndTest.rest.vm.UniversityVM;
import com.example.cleanCodeAndTest.service.interfaces.UniversityService;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {
    private final RestTemplate restTemplate;

    public UniversityServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<UniversityVM> getCountryUniversity(String country) {
        return
            new UniversityClient(restTemplate)
                .getCountryUniversities(country);
    }
}
