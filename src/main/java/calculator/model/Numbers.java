package calculator.model;

import calculator.exception.CalculateException;
import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private static final Integer ZERO = 0;
    private static final String ZERO_STRING = "";

    private final List<Integer> numbers;

    public Numbers(List<String> splitUserInput) {
        this.numbers = new ArrayList<>();
        makeNumbers(splitUserInput);
    }

    public void makeNumbers(List<String> splitUserInput) {
        for (String splitInput : splitUserInput) {
            numbers.add(isValidate(splitInput));
        }
    }

    public Integer isValidate(String splitInput) {
        if (compareSplitInputToZero(splitInput)) {
            return ZERO;
        }
        Integer number = CalculateException.catchNumberFormatException(splitInput);
        if (compareNumberWithZero(number)) {
            CalculateException.catchNumberNotPositiveException();
        }
        return number;
    }

    public boolean compareNumberWithZero(Integer number) {
        return number < ZERO;
    }

    public boolean compareSplitInputToZero(String splitInput) {
        return splitInput.equals(ZERO_STRING);
    }

    public Integer calculateNumbersSum() {
        Integer numbersSum = 0;
        for (Integer number : numbers) {
            numbersSum += number;
        }
        return numbersSum;
    }
}
