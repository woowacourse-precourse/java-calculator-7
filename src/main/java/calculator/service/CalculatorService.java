package calculator.service;

import calculator.exception.CalculatorException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorService {

    public int calculate(String input) {
        String inputString = input;
        String operandString = null;

        String containsDigit = ".*\\d.*";
        String isNumber = "^[0-9]*$";

        List<String> delimiterList = new ArrayList<>(Arrays.asList(",", ":"));
        String customDelimiter = null;

        int result = 0;

        if (inputString.isEmpty()) {
            return result;
        }

        if (!inputString.startsWith("//") && !inputString.contains(",") && !inputString.contains(":")) {
            throw new IllegalArgumentException(String.valueOf(CalculatorException.DELIMITER_NOT_FOUND));
        }

        if (!inputString.matches(containsDigit)) {
            throw new IllegalArgumentException(String.valueOf(CalculatorException.OPERAND_NOT_FOUND));
        }

        if (inputString.startsWith("//")) {
            int customDelimiterEndIndex = inputString.indexOf("\\n");

            if (!inputString.contains("\\n")) {
                throw new IllegalArgumentException(String.valueOf(CalculatorException.CUSTOM_DELIMITER_NOT_ALLOWED));
            }

            if (customDelimiterEndIndex == inputString.length() - 1) {
                throw new IllegalArgumentException(String.valueOf(CalculatorException.OPERAND_NOT_FOUND));
            }

            customDelimiter = inputString.substring(2, customDelimiterEndIndex);

            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException(String.valueOf(CalculatorException.CUSTOM_DELIMITER_NOT_BLANK));
            }

            if (customDelimiter.matches(isNumber)) {
                throw new IllegalArgumentException(String.valueOf(CalculatorException.CUSTOM_DELIMITER_NOT_NUMBER));
            }

            delimiterList.add(customDelimiter);
            operandString = inputString.substring(customDelimiterEndIndex + 2);

            String[] operands = operandString.split("[,:]|" + customDelimiter);
        } else {
            String[] operands = inputString.split("[,:]");
        }

        return result;
    }

}
