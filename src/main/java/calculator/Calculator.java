package calculator;

import constant.ErrorMessage;
import java.util.List;

public class Calculator {

    public int calculate(List<String> values) {
        try {
            int sum = 0;

            for (String value : values) {
                int num = Integer.parseInt(value);
                if (num <= 0) {
                    throw new IllegalArgumentException(ErrorMessage.CONTAINS_ZERO_OR_NEGATIVE);
                }
                sum += Integer.parseInt(value);
            }

            return sum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CHARACTER_FOUND);
        }
    }

}
