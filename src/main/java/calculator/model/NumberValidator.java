package calculator.model;

import calculator.exception.InvalidInputException;

public class NumberValidator {

    public int validateAndParse(String number) {
        int result = Integer.parseInt(number);
        if (result < 0) {
            throw new InvalidInputException("음수는 허용되지 않습니다: " + number);
        }
        return result;
    }
}
