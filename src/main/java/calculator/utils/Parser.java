package calculator.utils;

import calculator.model.Numbers;
import calculator.validators.NumberValidator;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private final int INITIAL_SIZE = 0;

    public Numbers parseInput(List<Character> delimiter, String input) {
        List<Integer> numbers = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        for (char current : input.toCharArray()) {
            if (delimiter.contains(current)) {
                tryToChangeStringToNumber(numbers, number);
                continue;
            }
            number.append(current);
        }
        tryToChangeStringToNumber(numbers, number);
        NumberValidator.numberValidate(numbers);
        return new Numbers(numbers);
    }

    private void tryToChangeStringToNumber(List<Integer> numbers, StringBuilder number) {
        try {
            if (!number.isEmpty()) {
                numbers.add(Integer.parseInt(number.toString()));
                number.setLength(INITIAL_SIZE);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }


}
