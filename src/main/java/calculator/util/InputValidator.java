package calculator.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    public void validateInputFormat(String input) {
        if (input.startsWith("//")) {
            int count = countMatches(input, "//(.)\\\\n(.*?)");

            if (count != 1) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
    }

    public void validateParsingStringToLong(List<String> arguments) {
        try {
            for (String argument : arguments) {
                Long.parseLong(argument);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 있습니다.");
        }
    }

    public void validatePositiveNumberList(List<Long> list) {
        list.forEach(element -> {
            if (element <= 0) {
                throw new IllegalArgumentException("양수가 아닌 값이 포함되어 있습니다.");
            }
        });
    }

    private int countMatches(String input, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(input);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }
}
