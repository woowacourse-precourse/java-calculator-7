package calculator;

import static calculator.StringValidator.getSumString;
import static calculator.StringValidator.userInputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumCalculator {

    private SumCalculator() {
    }

    public static Integer getFinalResult(String userInput) {
        List<String> delimiters;
        delimiters = userInputValidator(userInput);

        String sumString = getSumString(userInput, delimiters);

        List<Integer> numbers = (getNumbers(sumString, delimiters)).stream().map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> integerList = vaildateNumber(numbers);
        return getSumInteger(integerList);
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

    public static Integer getSumInteger(List<Integer> numbers) {
        Integer sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }


}
