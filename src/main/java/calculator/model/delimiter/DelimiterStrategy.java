package calculator.model.delimiter;


import java.util.Arrays;

public interface DelimiterStrategy {

    String[] getStringArray(String input);

    default String[] checkDuplicatedDelimiters(String[] numbers) {
        if (Arrays.asList(numbers).contains("")) {
            throw new IllegalArgumentException("[Error] 연속된 구분자가 있을 수 있습니다.");
        }
        return numbers;
    }
}