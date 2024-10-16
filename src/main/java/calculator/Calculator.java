package calculator;

import java.util.List;

public class Calculator {
    // TODO : 메서드를 더 나눠야함. calculator 는 현재 parsing 및 덫셈 작업, validation을 하고있음
    // TODO : validation -> (IAE 터트리게), parsing 작업 후 숫자만 반환, calculaator는 반환 된 숫자를 더할 수 있도록

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        if (DelimiterParser.isDefaultDelimiter(input)) {
            DelimiterParser delimiterParser = new DelimiterParser(":");
            String replace = delimiterParser.replace(input);

            List<Integer> inputNums = DelimiterParser.parseToIntList(replace);
            Validator.validateIfInputNegative(inputNums);

            return inputNums.stream()
                    .mapToInt(Integer::valueOf)
                    .sum();
        }

        if (!DelimiterParser.isDefaultDelimiter(input)) {
            String delimiter1 = input.substring(0, 2);
            String delimiter2 = input.substring(3, 5);
            DelimiterParser delimiterParser = new DelimiterParser(delimiter1, delimiter2);
            String replaceInput = delimiterParser.replace(input);
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
