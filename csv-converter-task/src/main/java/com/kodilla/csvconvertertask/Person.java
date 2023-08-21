package com.kodilla.csvconvertertask;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {

    private String name;
    private String surname;
    private String dateOfBirth;
}
