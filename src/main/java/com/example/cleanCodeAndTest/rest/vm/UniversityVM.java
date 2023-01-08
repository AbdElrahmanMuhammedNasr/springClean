package com.example.cleanCodeAndTest.rest.vm;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
public class UniversityVM {
    private List<String> web_pages;
//    private String state_province;
//    private String alpha_two_code;
    private String name;
    private String country;
//    private List<String> domains;
}
