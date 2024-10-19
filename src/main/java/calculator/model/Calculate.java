package calculator.model;


import calculator.validation.InputValidator;

import java.util.Arrays;

public class Calculate {
    private static final calculator.model.Parser parser = new Parser();

    public static int calculateTotalSum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(parser::toInt)
                .sum();
    }
}