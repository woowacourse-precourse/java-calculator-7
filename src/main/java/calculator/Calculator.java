package calculator;

import java.util.List;

public class Calculator {
    private DelimiterParser delimiterParser = new DelimiterParser();
    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        if (delimiterParser.isDefaultDelimiter(input)) {
            DelimiterParser delimiterParser = new DelimiterParser(":");
            String result = delimiterParser.splitByDelimiter(input);

            List<Integer> inputNums = delimiterParser.parseToIntList(result);
            Validator.validateIfInputNegative(inputNums);

            return inputNums.stream()
                    .mapToInt(Integer::valueOf)
                    .sum();
        }

        if (!delimiterParser.isDefaultDelimiter(input)) {
            String delimiter1 = input.substring(0, 2);
            String delimiter2 = input.substring(3, 5);
            DelimiterParser delimiterParser = new DelimiterParser(delimiter1, delimiter2);

            String result = delimiterParser.splitByDelimiter(input);
            String customDelimiter = result.substring(0, 1);
            String numberPart = result.substring(1);
            String[] split = numberPart.split(customDelimiter);

            String splitString = String.join(",", split);
            List<Integer> inputNums = delimiterParser.parseToIntList(splitString); // -> 123 백이십삼
            Validator.validateIfInputNegative(inputNums);

            return inputNums.stream()
                    .mapToInt(Integer::valueOf)
                    .sum();
        }
        return 0;
    }
}
