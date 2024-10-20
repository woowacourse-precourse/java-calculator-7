package calculator;

import calculator.delimiter.BasicDelimiterHandler;
import calculator.delimiter.CustomDelimiterHandler;
import calculator.exception.InvalidInputException;

public class StringCalculator {

    public int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInputException("입력값이 없습니다.");
        }

        DelimiterHandler delimiterHandler;

        // 커스텀 구분자가 있는지 확인
        if (CustomDelimiterHandler.isCustomDelimiter(input)) {
            delimiterHandler = new CustomDelimiterHandler();
        } else {
            delimiterHandler = new BasicDelimiterHandler();
        }

        String[] numbers = delimiterHandler.split(input);

        return sum(numbers);
    }

    private int sum(String[] numbers) {
        int total = 0;

        for (String number : numbers) {
            // 숫자 변환 시 예외 처리
            int num = parseNumber(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
            }
            total += num;
        }

        return total;
    }

    private int parseNumber(String number) {
        // 숫자로 변환 시 공백 제거
        number = number.trim();

        // 숫자가 아닐 경우 예외 처리
        if (!number.isEmpty()) {
            try {
                return Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 숫자: " + number);
            }
        }
        return 0; // 빈 문자열의 경우 0 반환
    }
}
