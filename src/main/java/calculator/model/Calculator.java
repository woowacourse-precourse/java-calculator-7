package calculator.model;

import calculator.validation.Validation;

public class Calculator {
    public static String[] separateNumber(String input, String delimiter) {
        String[] numberGroup = input.split(delimiter);
        return numberGroup;
    }

    public static int findSum(String[] numberGroup) {
        int sum = 0;
        for (String number : numberGroup) {
            Validation.validateNumberFormat(number);
            Validation.validateIntRange(number);
            Validation.validateNegativeNumber(number);

            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
