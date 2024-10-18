package calculator.model;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    private static final String ALLOWED_FROM = "^[0-9]*[:,][0-9]*[:,][0-9]*$";
    private static final String NUMBER_FROM = "^[0-9]*";

    public StringCalculator() {
    }

    public void validateInputStringFrom(String inputString) {
        if (!inputString.matches(ALLOWED_FROM)) {
            throw new IllegalArgumentException("문자열 입력 양식이 맞지 않습니다.");
        }
    }

    public String getAllowedFrom() {
        return ALLOWED_FROM;
    }

    public void calculate(String inputString) {
        validateInputStringFrom(inputString);
    }

    public List<Long> filter(String inputString) {
        return Arrays.stream(inputString.split(""))
                .filter(token -> token.matches(NUMBER_FROM))
                .map(Long::parseLong)
                .toList();
    }
}
