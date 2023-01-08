package com.example.cleanCodeAndTest.service.interfaces;

import com.example.cleanCodeAndTest.rest.vm.UniversityVM;

import java.util.List;

public interface UniversityService {
    List<UniversityVM> getCountryUniversity(String country);
}
