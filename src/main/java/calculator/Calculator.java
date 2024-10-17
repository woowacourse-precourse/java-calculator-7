package calculator;

import java.util.List;

public class Calculator {

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        if (DelimiterParser.isDefaultDelimiter(input)) {
            DelimiterParser delimiterParser = new DelimiterParser(":");
            String result = delimiterParser.splitByDelimiter(input);

            List<Integer> inputNums = DelimiterParser.parseToIntList(result);
            Validator.validateIfInputNegative(inputNums);

            return inputNums.stream()
                    .mapToInt(Integer::valueOf)
                    .sum();
        }

        if (!DelimiterParser.isDefaultDelimiter(input)) {
            String delimiter1 = input.substring(0, 2);
            String delimiter2 = input.substring(3, 5);
            DelimiterParser delimiterParser = new DelimiterParser(delimiter1, delimiter2);
            String replaceInput = delimiterParser.splitByDelimiter(input);
            String customDelimiter = replaceInput.substring(0, 1);
            String numberPart = replaceInput.substring(1);
            String[] split = numberPart.split(customDelimiter);

            String splitString = String.join(",", split);
            List<Integer> inputNums = DelimiterParser.parseToIntList(splitString); // -> 123 백이십삼
            Validator.validateIfInputNegative(inputNums);

            return inputNums.stream()
                    .mapToInt(Integer::valueOf)
                    .sum();
        }
        return 0;
    }
}
