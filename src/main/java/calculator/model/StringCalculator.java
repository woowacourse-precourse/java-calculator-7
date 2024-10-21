package calculator.model;

import calculator.global.error.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class StringCalculator {

    private final DelimiterExtractor delimiterExtractor;

    public StringCalculator() {
        this.delimiterExtractor = new DelimiterExtractor();
    }


    public int add(String input) {

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_EMPTY.getMessage());
        }

        // 구분자를 추출하고 입력에서 숫자 부분을 분리
        String delimiters = delimiterExtractor.getDelimiters(input);
        String numbersPart = getNumbersPart(input);

        // 구분자로 숫자를 분리하고 합산
        String[] numbers = numbersPart.split(delimiters);

        if (areAllEmpty(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.ALL_NUMBERS_ARE_EMPTY.getMessage());
        }

        return sum(numbers);
    }

    private String getNumbersPart(String input) {
        if (input.startsWith("//")) {
            return input.substring(input.indexOf("\n") + 1); // 구분자 이후 숫자 부분 반환
        }
        return input;
    }

    // 숫자 배열에 빈 값만 있을 경우 true를 반환
    private boolean areAllEmpty(String[] numbers) {
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            int num = parseNumber(number);
            if (num < 0) {
                throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBERS_ARE_NOT_ALLOWED.getMessage() + ": " + num);
            }
            total += num;
        }
        return total;
    }


    private int parseNumber(String number) {
        try {
            return Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.AN_INVALID_NUMBER_WAS_ENTERED.getMessage() + " : " + number);
        }
    }
}
