package calculator.service;



import calculator.domain.Calculator;
import calculator.domain.Separator;
import calculator.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

public class CalculationService {

    private final Separator separator;
    private final Calculator calculator;

    public CalculationService() {
        this.separator = new Separator();
        this.calculator = new Calculator();
    }

    public int calculate(String input) {
        checkParams(input);
        extractNumbers(input);
        List<Integer> nums = separator.getNums();
        return calculator.calculate(nums);
    }

    private void checkParams(String input) {
        String processedString = checkNewParam(input);
        for (char ch : processedString.toCharArray()) {
            if (!Character.isDigit(ch) && !separator.getParams().contains(ch)) {
                throw new InvalidInputException("허용되지 않는 문자입니다.");
            }
        }
    }

    private String checkNewParam(String input) {
        if (input.startsWith("//")) {
            char newParam = input.charAt(2);
            separator.getParams().add(newParam);
            return input.substring(5);
        }
        return input;
    }

    private void extractNumbers(String input) {
        StringBuilder currentNumber = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                currentNumber.append(ch);
            } else {
                if (!currentNumber.isEmpty()) {
                    separator.addNum(Integer.parseInt(currentNumber.toString()));
                    currentNumber.setLength(0);
                }
            }
        }

        if (!currentNumber.isEmpty()) {
            separator.addNum(Integer.parseInt(currentNumber.toString()));
        }


    }
}