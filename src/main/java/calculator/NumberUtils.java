package calculator;

import java.util.Arrays;
import java.util.List;

public class NumberUtils {

    public static List<Integer> splitNumbers(DelimiterAndNumber delimiterAndNumber) {
        String delimiters = delimiterAndNumber.delimiters();
        String numbersString = delimiterAndNumber.numbersString();
        String[] splitNumbers = numbersString.split(delimiters);
        return Arrays.stream(splitNumbers)
                .map(Integer::parseInt)
                .toList();
    }


    public static int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
