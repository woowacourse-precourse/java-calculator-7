package calculator.validation;

import calculator.exception.ErrorMessage;

import java.util.Arrays;

public class DelimiterNumberValidator {

    public int[] isValidNumber(String[] number) {
        return Arrays.stream(number)
                .mapToInt(this::parseNumber)
                .toArray();
    }

    private int parseNumber(String number) {
        if (isNumeric(number)) {
            int parseInt = Integer.parseInt(number);

            if (parseInt < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            return parseInt;
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }

}