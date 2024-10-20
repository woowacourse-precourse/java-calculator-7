package calculator;

import java.util.Arrays;

public class StringCalculator {
    public int add(String input) {
        String[] numbers = split(input);

        // Todo: 문자열 변환 및 합계

        return -1;
    }

    public String[] splitTest(String input) {
        return split(input);
    }

    private String[] split(String input) {
        String delimiter = "[,:]";

        return input.split(delimiter);
    }
}
