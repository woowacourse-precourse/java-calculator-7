package calculator.model;

import calculator.exception.InvalidInputException;

public class NumberValidator {

    public int validateAndParse(String number) {
        try {
            int result = Integer.parseInt(number);
            if (result < 0) {
                throw new InvalidInputException("음수는 허용되지 않습니다: " + number);
            }
            return result;
        } catch (NumberFormatException e) {
            throw new InvalidInputException("유효한 숫자가 아닙니다: " + number, e);
        }
    }
}
