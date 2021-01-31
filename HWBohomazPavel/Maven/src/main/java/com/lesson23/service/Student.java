package com.lesson23.service;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Student {

    private String fullName;
    private int group;
    private int yearOfAdmission;

    public Student(String fullName, int group, int yearOfAdmission) {
        this.fullName = fullName;
        this.group = group;
        this.yearOfAdmission = yearOfAdmission;
    }
}
