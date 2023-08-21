package com.kodilla.csvconvertertask;

import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PersonProcessor implements ItemProcessor<Person, PersonWithAge> {

    @Override
    public PersonWithAge process(Person item) throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate dateOfBirth = LocalDate.parse(item.getDateOfBirth(), formatter);

        int age = LocalDate.now()
                .minusYears(dateOfBirth.getYear())
                .minusMonths(dateOfBirth.getMonthValue())
                .minusDays(dateOfBirth.getDayOfMonth())
                .getYear();
        return new PersonWithAge(item.getName(), item.getSurname(), age);
    }
}
