package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.Delimiters;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CalculatorService {

    private static final Set<Character> DEFAULT_DELIMITERS = Set.of(',', ':');

    public Integer addCalculator(String userInput) {
        validateNullInput(userInput);
        Calculator calculator = new Calculator();
        Delimiters delimiters = new Delimiters(DEFAULT_DELIMITERS);
        String parsedInput = delimiters.extractCustomDelimiter(userInput);
        calculator.addNumbers(splitNumbers(parsedInput, delimiters));
        return calculator.sum();
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

    private void validateNullInput(String userInput) {
        if(userInput == null){
            throw new IllegalArgumentException("User input is empty");
        }
    }
}
