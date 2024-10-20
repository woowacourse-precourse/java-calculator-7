package calculator.utils;

import calculator.exception.InvalidDelimiterException;
import calculator.exception.InvalidNumberException;
import java.util.List;

public class Validator {

    public static void validateNumberList(List<Double> numbers) {
        for (Double number : numbers) {
            if (number <= 0) {
                throw new InvalidNumberException("숫자는 양수만 가능합니다");
            }
        }
    }

    public static void validateCustomDelimiter(String customDelimiter) {
        if (customDelimiter.length() != 1 || Character.isDigit(customDelimiter.charAt(0))) {
            throw new InvalidDelimiterException("커스텀 구분자는 1자리만 가능합니다");
        }
    }
}

