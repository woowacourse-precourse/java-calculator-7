package calculator.model;

import calculator.exception.ErrorMessages;
import java.util.Arrays;

public class Calculator {

    private static final String DEFAULT_DELIMITERS = ",:"; // 기본 구분자
    private final NumberParser numberParser;
    private final DelimiterParser delimiterParser; // DelimiterParser 추가

    public Calculator() {
        this.numberParser = new NumberParser(DEFAULT_DELIMITERS);
        this.delimiterParser = new DelimiterParser(); // DelimiterParser 초기화
    }

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0; // 비어있는 입력 처리
        }

        // 커스텀 구분자 처리
        String customDelimiter = delimiterParser.parseCustomDelimiter(input);
        String numbersPart = input;

        if (customDelimiter != null) {
            numbersPart = input.substring(input.indexOf("\\n") + 2); // 구분자 뒤의 숫자 부분 추출
            if (numbersPart.isEmpty()) {
                throw new IllegalArgumentException(
                        ErrorMessages.EMPTY_NUMBER_AFTER_CUSTOM_DELIMITER); // 커스텀 구분자 뒤에 숫자가 없을 때
            }
        }

        // 숫자 파싱 및 합산
        String[] numbers = numberParser.parseNumbers(numbersPart, customDelimiter);
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}