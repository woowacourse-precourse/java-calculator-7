package calculator.util;

import static calculator.config.SystemConstantMessages.UTILITY_CLASS_MESSAGE;

public class Calculator {
    private Calculator() {
        throw new IllegalStateException(UTILITY_CLASS_MESSAGE);
    }

    public static Integer addNumbers(Integer[] parsedNumbers) {
        int sum = 0;
        for (int num : parsedNumbers) {
            sum += num;
        }
        return sum;
    }
}
