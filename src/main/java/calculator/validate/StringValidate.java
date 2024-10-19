package calculator.validate;

import java.util.Objects;

public class StringValidate {
    public static void validateNotNullInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력한 문자열이 null 입니다.");
        }
    }

    public static boolean isInputStartWithSlash(String input) {
        return input.startsWith("//");
    }

    public static void validateNewLineInput(String input) {
        if (!input.contains("\n")) {
            throw new IllegalArgumentException("문자열에 '\n'이 있어야 합니다.");
        }
    }

    public static boolean validateBackString(String string, String separator) {
        if (Objects.equals(string, "")) {
            return true;
        }

        for (String s : string.split("")) {
            if (Character.isDigit(s.charAt(0))) {
                continue;
            }
            if (!separator.contains(s)) {
                throw new IllegalArgumentException("계산해야 하는 문자열에 구분자가 아닌 문자가 있습니다.");
            }
        }
        return true;
    }
}
