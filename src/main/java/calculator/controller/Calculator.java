package calculator.controller;

import calculator.model.NumberConverter;


import static calculator.model.Separator.*;

public class Calculator {


    public Calculator() {
        activeSeparator = DEFAULT_SEPARATOR;
    }

    public int sum(String[] tokens) {
        int total = 0;
        for (String token : tokens) {
            total += NumberConverter.convertToInt(token.trim());
        }
        return total;
    }


}
