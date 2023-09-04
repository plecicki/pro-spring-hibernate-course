package com.kodilla.bytecode.reflection.academy;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RangeValidator implements ConstraintValidator<Range, Integer> {

    private int maxValue;
    private int minValue;

    @Override
    public void initialize(Range constraintAnnotation) {
        maxValue = constraintAnnotation.max();
        minValue = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value <= maxValue && value >= minValue;
    }
}
