package calculator.model;

import calculator.delimiter.CustomDelimiter;
import calculator.delimiter.DefaultDelimiter;
import calculator.validator.InputValidator;
import calculator.validator.NegativeNumberValidator;

import java.util.regex.Matcher;

public class CalculatorModel {

    // 입력값 유효성 검사
    public void validateInput(String input) {
        InputValidator.validate(input);
    }

    // 문자열의 합 계산
    public int calculateSum(String input) {
        String delimiter = DefaultDelimiter.getDefaultDelimiter();
        Matcher matcher = CustomDelimiter.getCustomDelimiterMatcher(input);

        if (matcher.find()) {
            delimiter = CustomDelimiter.getCustomDelimiter(matcher);
            input = CustomDelimiter.getNumbersWithCustomDelimiter(matcher);
        }

        return sumNumbers(input, delimiter);
    }

    // 문자열을 숫자로 분리하고 합산하는 메서드
    private int sumNumbers(String str, String delimiter) {
        String[] numbers = str.split(delimiter);
        int sum = 0;

        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                int num = Integer.parseInt(number.trim());
                NegativeNumberValidator.checkNegativeNumber(num);
                sum += num;
            }
        }

        return sum;
    }
}
