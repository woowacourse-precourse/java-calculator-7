package calculator.model;

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

        try {
            return Integer.parseInt(splitInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("에러 메시지-정수 변환");
        }
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
