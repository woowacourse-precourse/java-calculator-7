package calculator.validate;

import java.util.Objects;

public class StringValidate {
    public static void validateNotNullInput(final String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력한 문자열이 null 입니다.");
        }
    }

    public static boolean isInputStartWithSlash(final String input) {
        return input.startsWith("//");
    }

    public static void validateNewLineInput(final String input) {
        if (input.contains("\n") || input.contains("\\n")) {
            return;
        }

        throw new IllegalArgumentException("문자열에 '\n' 또는 '\\n'이 있어야 합니다.");
    }

    public static void validateSeperator(final String seperator) {
        if (seperator.chars().anyMatch(Character::isDigit)) {
            throw new IllegalArgumentException("해당 문자열은 문자로만 이루어져야 합니다.");
        }
    }


    public static void validateCalFormula(final String string, final String separator) {
        if (!Objects.equals(string, "")) {
            for (String s : string.split("")) {
                if (Character.isDigit(s.charAt(0))) {
                    continue;
                }
                if (!separator.contains(s)) {
                    throw new IllegalArgumentException("계산해야 하는 문자열에 구분자가 아닌 문자가 있습니다.");
                }
            }
        }
    }
}
