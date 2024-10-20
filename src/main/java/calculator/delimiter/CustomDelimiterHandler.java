package calculator.delimiter;

import calculator.DelimiterHandler;
import calculator.exception.InvalidInputException;

public class CustomDelimiterHandler implements DelimiterHandler {

    public static boolean isCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    @Override
    public String[] split(String input) {
        if (!isCustomDelimiter(input)) {
            throw new InvalidInputException("유효하지 않은 구분자입니다.");
        }

        // 커스텀 구분자 추출
        int endIndex = input.indexOf("\n");
        if (endIndex == -1) {
            throw new InvalidInputException("//와 \n을 사용하여 커스텀 구분자를 지정해야 합니다.");
        }

        String customDelimiter = input.substring(2, endIndex);
        if (customDelimiter.length() != 1) {
            throw new InvalidInputException("커스텀 구분자는 한 글자여야 합니다.");
        }

        // 숫자 부분 추출
        String numbersPart = input.substring(endIndex + 1);
        return numbersPart.split(customDelimiter); // 커스텀 구분자로 문자열 분리
    }
}
