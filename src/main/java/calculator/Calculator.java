package calculator;

import java.util.Arrays;

public class Calculator {

    public int sum(String[] numberArr) {
        return Arrays.stream(numberArr).mapToInt(Integer::parseInt).sum();
    }
}
