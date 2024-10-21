package calculator.common;

import calculator.common.CustomExceptions.ArithmeticOverflowException;
import calculator.common.CustomExceptions.InvalidCharacterException;
import calculator.common.CustomExceptions.InvalidNumberException;
import calculator.common.CustomExceptions.NegativeNumberException;

public class InputValidator {

    public static void validateNumbers(String[] tokens) {
        try {
            long sum = 0;
            for (String token : tokens) {
                int number = getNumber(token);

                sum += number;
                if (sum > Integer.MAX_VALUE) {
                    throw new ArithmeticOverflowException("정수 합이 Integer 범위를 초과했습니다.");
                }
            }
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("유효하지 않은 숫자 형식입니다.");
        }
    }

    private static int getNumber(String token) {
        String trimmedToken = token.trim();

        if (trimmedToken.isEmpty()) {
            throw new InvalidNumberException("입력값에 연속된 구분자 또는 공백만 포함된 부분이 있습니다.");
        }

        if (!trimmedToken.matches("-?\\d+")) {
            throw new InvalidCharacterException("입력값에 구분자와 숫자 외의 문자가 포함되어 있습니다.");
        }

        int number = Integer.parseInt(trimmedToken);
        if (number < 0) {
            throw new NegativeNumberException("음수 입력값은 허용되지 않습니다.");
        }
        return number;
    }
}
