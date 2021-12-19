package com.epam.task2.geometry.director;

import java.util.regex.Pattern;

public class ConeValidator {

    private static final String VALIDATION_REGEX = "(\\d+\\s){4}\\d+";
    private static final String DELIMITER = " ";

    public ConeValidator() {
    }

    public boolean isValid(String inputFiveParameters) {
        boolean validationResult = false;
        if (Pattern.matches(VALIDATION_REGEX, inputFiveParameters)) {
            validationResult = zeroValidation(inputFiveParameters);
        }
        return validationResult;
    }

    private static boolean zeroValidation(String inputFiveParameters) {
        String[] parametersForCreate = inputFiveParameters.split(DELIMITER);
        Integer[] integerTypeParameters = new Integer[parametersForCreate.length];
        boolean result = false ;
        if (!parametersForCreate[3].equals("0") && !parametersForCreate[4].equals("0") ) {
            result = true ;
        }
        return result;
    }
}