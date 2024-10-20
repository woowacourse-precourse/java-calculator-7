package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.Delimiters;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CalculatorService {

    private static final String regex = "^//[^0-9]\\\\n.*";

    public Integer addCalculator(String userInput) {
        Calculator calculator = new Calculator();
        Delimiters delimiters = new Delimiters(Set.of(',', ':'));
        String parsedInput = extractCustomDelimiter(userInput, delimiters);
        calculator.addNumbers(splitNumbers(parsedInput, delimiters));
        return calculator.calculateSum();
    }

    public String extractCustomDelimiter(String userInput, Delimiters delimiters) {
        if(userInput.startsWith("/")){
            validateInputFormat(userInput);
            delimiters.addDelimiter(userInput.charAt(2));
            return userInput.substring(5);
        }

        return userInput;
    }

    public List<Integer> splitNumbers(String parsedInput, Delimiters delimiters) {
        List<Integer> numbers = new ArrayList<>();
        int temp = 0;

        for (char cur : parsedInput.toCharArray()) {
            if (Character.isDigit(cur)) {
                temp = temp * 10 + (cur - '0');
            } else if (delimiters.isDelimiter(cur)) {
                numbers.add(temp);
                temp = 0;
            } else {
                throw new IllegalArgumentException("잘못된 문자가 존재합니다.");
            }
        }

        numbers.add(temp);

        return numbers;
    }


    private void validateInputFormat(String userInput) {
        if(!userInput.matches(regex)){
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
    }
}
