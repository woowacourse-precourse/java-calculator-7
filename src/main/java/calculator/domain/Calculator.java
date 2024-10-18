package calculator.domain;

import java.util.List;

public class Calculator {

    private static final String NEGATIVE_NUMBER_ERROR = "[ERROR] 양수만 입력 가능합니다.";

    private void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR);
        }
    }
}
