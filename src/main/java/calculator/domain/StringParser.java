package calculator.domain;

import calculator.enums.Delimiter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {

    public static int calculateInput(String input) {
        String[] numbers = splitCustomInput(input);
        List<Integer> intNumbers = convertIntList(numbers);
        return intNumbers.stream().mapToInt(Integer::intValue).sum();
    }

    public static String[] splitCustomInput(String input) {
        // 커스텀 구분자를 사용하는 경우
        if (input.startsWith(Delimiter.CUSTOM_FIRST_DELIMITER.toString())) {
            int delimiterEndIndex = input.indexOf(Delimiter.CUSTOM_SECOND_DELIMITER.toString());

            String customDelimiter = input.substring(2, delimiterEndIndex);
            String numbers = input.substring(delimiterEndIndex + 1);

            customDelimiter = customDelimiter.replaceAll("([\\W&&[^\\s]])", "\\\\$1");

            return numbers.split(customDelimiter + "|" + Delimiter.DEFAULT_DELIMITERS.toString());
        } else {
            return input.split(Delimiter.DEFAULT_DELIMITERS.toString());  // 기본 구분자를 사용하는 경우
        }
    }

    public static List<Integer> convertIntList(String[] numbers) {
        return Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());
    }
}
