package calculator.util;

import calculator.message.Delimiter;
import calculator.message.ErrorMessage;
import java.util.List;

public class Validator {
    public static String validateInput(String userInput) {
        isBlank(userInput);
        String newInput = validateCustomDelimiter(userInput);

        return newInput;
    }

    // 입력받은 문자열이 공백이라면 예외 처리 (0 을 반환하도록 리팩토링 할 예정)
    private static void isBlank(String str) {
        if (str.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT_MESSAGE);
        }
    }

    // 구분자를 기준으로 나눈 숫자들 중에 음수가 있다면 예외 처리
    public static void isNegativeNumber(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < 0) {
                throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER_MESSAGE);
            }
        });
    }

    // 커스텀 구분자를 입력하는 부분은 문자열 검증 로직에서 제외
    public static String validateCustomDelimiter(String str) {
        if (str.length() >= 5 && str.startsWith("//") && str.charAt(3) == '\\' && str.charAt(4) == 'n') {
            Delimiter.CUSTOM_DELIMITER = String.valueOf(str.charAt(2));
            return str.substring(5);
        }

        return str;
    }
}