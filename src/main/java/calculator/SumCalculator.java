package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumCalculator {

    private SumCalculator() {
    }

    public static List<String> getNumbers(String sumString, List<String> delimiters) {
        String delimitersString = delimiters.stream()
                .map(delimiter -> "\\" + delimiter)
                .collect(Collectors.joining("|"));
        String[] numbers = sumString.split(delimitersString);
        return Arrays.asList(numbers);
    }


    public static List<Integer> vaildateNumber(List<Integer> numbers) throws IllegalArgumentException {
        for (Integer number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException();
            }
        }
        return numbers;
    }


}
