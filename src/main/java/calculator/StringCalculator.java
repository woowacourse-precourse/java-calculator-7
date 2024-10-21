package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public StringCalculator() {
    }

    public int calculate(String string) {
        if (string.isEmpty()) {
            return 0;
        }

        String[] tokens = split(string);

        validate(tokens);
    }

    private String[] split(String string) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(string);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return string.split(",|:");
    }

    private void validate(String[] tokens) {
        for(String token : tokens) {
            validatePositiveInteger(token);
        }
    }

    private void validatePositiveInteger(String string){
        if (!string.matches("[0-9]\\d*")) {
            throw new IllegalArgumentException("양수가 아닌 값이 입력되었습니다.");
        }
    }
}
