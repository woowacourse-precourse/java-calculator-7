package calculator.domain;

import calculator.exception.ErrorMessage;
import java.util.List;

public class Numbers {

    private static final int STANDARD = 0;

    private final List<Integer> numberList;

    public Numbers(List<Integer> numberList) {
        validatePositive(numberList);
        this.numberList = numberList;
    }

    private void validatePositive(List<Integer> numberList) {
        if (isNotPositive(numberList)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_ONLY_POSITIVE.getMessage());
        }
    }

    private boolean isNotPositive(List<Integer> numberList) {
        return numberList
                .stream()
                .anyMatch(number -> number <= STANDARD);
    }

    public List<Integer> getNumbers() {
        return numberList;
    }
}