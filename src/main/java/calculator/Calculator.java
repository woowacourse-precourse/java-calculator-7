package calculator;


import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static String DEFAULT_DELIMITERS = ",|:";
    private static final Validator validator = new Validator();

    public List<Integer> splitString(String input) {
        if (input == null || input.isEmpty()) {
            return List.of(0);
        }

        String customNumber = customDelimiter(input);
        String[] tokens = customNumber.split(DEFAULT_DELIMITERS);

        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            int num = validator.isValid(token);
            validator.isNumber(num);
            numbers.add(num);
        }

        return numbers;
    }

    public String customDelimiter(String input) {
        if (input.startsWith("//")) {
            int endIndex = input.indexOf("\\"+"n");
            if (endIndex == -1) {
                throw new IllegalArgumentException();
            }

            String customDelimiter = input.substring(2, endIndex);
            DEFAULT_DELIMITERS = DEFAULT_DELIMITERS + "|" +customDelimiter;
            return input.substring(endIndex + 2);
        }
        return input;
    }

    public Integer sumNumbers(List<Integer> numbers) {
        Integer sum = 0;
        for (Integer i : numbers) {
            sum += i;
        }

        return sum;
    }
}
