package calculator;

import java.util.List;
import java.util.Optional;

public class Validator {

    public static Optional<String> checkCustomSeparator(String input) {
        String customDelim = null;
        if (input.startsWith(Delimiter.CUSTOM_SEPARATOR_START.getValue())) {
            if (!input.contains(Delimiter.CUSTOM_SEPARATOR_END.getValue())) {
                throw new IllegalArgumentException("\n지정 구분자는 //와 \\n 사이에 입력해주세요");
            }

            customDelim = input.substring(
                    2,
                    input.indexOf(Delimiter.CUSTOM_SEPARATOR_END.getValue())
            );
        }

        return Optional.ofNullable(customDelim);
    }

    public static void checkString(List<String> strs) {
        for (String str : strs) {
            if (str.isEmpty() || str.isBlank()) {
                continue;
            }

            if (!str.matches(Regex.NUMBER_REGEX.getPattern())) {
                throw new IllegalArgumentException(str + " 는 허용되지 않는 문자입니다");
            }
        }
    }
}
