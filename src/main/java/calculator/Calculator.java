package calculator;

import java.util.List;

public class Calculator {


    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        DelimiterParser delimiterParser;
        // 기본 구분자 처리
        if (DelimiterParser.isDefaultDelimiter(input)) {
            delimiterParser = new DelimiterParser(":");

            String result = delimiterParser.replace(input);
            List<Integer> inputNums = delimiterParser.parseToIntList(result);
            Validator.validateIfInputNegative(inputNums);

            return inputNums.stream()
                    .mapToInt(Integer::valueOf)
                    .sum();
        }

        // 커스텀 구분자 처리
        else {
            String delimiter1 = input.substring(0, 2);
            String delimiter2 = input.substring(3, 5);
            delimiterParser = new DelimiterParser(delimiter1, delimiter2);

            String replaceInput = delimiterParser.replace(input);
            String customDelimiter = replaceInput.substring(0, 1);
            String numberPart = replaceInput.substring(1);
            String[] split = numberPart.split(customDelimiter);

            String splitString = String.join(",", split);
            List<Integer> inputNums = delimiterParser.parseToIntList(splitString);
            Validator.validateIfInputNegative(inputNums);

            return inputNums.stream()
                    .mapToInt(Integer::valueOf)
                    .sum();
        }
    }
}
