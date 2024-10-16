package calculator;

import java.util.List;

public class NumberValidator {
    public void validate(List<String> splitNumber) {
        for (String candidate : splitNumber) {
            validParseNumber(candidate);
        }
    }

    private void validParseNumber(String number) {
        if (number.isBlank()) {
            return;
        }

        try {
            Double.parseDouble(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
