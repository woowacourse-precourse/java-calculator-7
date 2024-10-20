package calculator;

import calculator.delimiter.BasicDelimiterHandler;
import calculator.delimiter.CustomDelimiterHandler;
import calculator.exception.InvalidInputException;

public class StringCalculator {

    public int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInputException("입력값이 없습니다.");  // 빈 문자열일 경우 예외 발생
        }

        if (!CustomDelimiterHandler.isCustomDelimiter(input) && !input.contains(",") && !input.contains(":")) {
            throw new InvalidInputException("유효하지 않은 구분자입니다."); // 커스텀 구분자와 기본 구분자가 아닌 경우 예외 발생
        }

        DelimiterHandler delimiterHandler = CustomDelimiterHandler.isCustomDelimiter(input)
                ? new CustomDelimiterHandler()
                : new BasicDelimiterHandler();

        String[] numbers = delimiterHandler.split(input);
        return sum(numbers);
    }


    private int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            int num = parseNumber(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
            }
            total += num;
        }
        return total;
    }

    private int parseNumber(String number) {
        if (number.trim().isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 숫자: " + number);
        }

        try {
            return Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자: " + number);
        }
    }
}
