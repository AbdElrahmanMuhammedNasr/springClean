package com.example.cleanCodeAndTest.client;

import com.example.cleanCodeAndTest.utils.UnivrersityUtils;
import com.example.cleanCodeAndTest.rest.vm.UniversityVM;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class UniversityClient {

    private final RestTemplate restTemplate;

    public UniversityClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UniversityVM> getCountryUniversities(String country){
        Map<String, String> params = new HashMap<>();
        params.put("country", country);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<UniversityVM[]> response =  restTemplate.exchange(
            UnivrersityUtils.UNIVERSITY_URL,
            HttpMethod.GET,
            requestEntity,
            UniversityVM[].class ,
            params);
        return List.of(Objects.requireNonNull(response.getBody()));
    }
}
