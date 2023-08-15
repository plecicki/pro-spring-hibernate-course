package com.kodilla.converter.domain;

public class MyCustomClassHomework {

    private final String fieldOne;
    private final String fieldTwo;
    private final String fieldThree;

    public MyCustomClassHomework(String field1, String field2, String field3) {
        fieldOne = field1;
        fieldTwo = field2;
        fieldThree = field3;
    }

    public String getFieldOne() {
        return fieldOne;
    }

    public String getFieldTwo() {
        return fieldTwo;
    }

    public String getFieldThree() {
        return fieldThree;
    }
}
