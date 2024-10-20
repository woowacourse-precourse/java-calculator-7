package calculator.validator;

public class ValidationUtils {
    public static void validateStartWithDoubleSlash(String inputString) {
        if (!inputString.startsWith("//") && !Character.isDigit(inputString.charAt(0))) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다: " + inputString);
        }
    }

    public static void validateDuplicatedCharacter(String delimiterString) {
        StringBuilder checkedDelimiter = new StringBuilder();
        for (char delimiter : delimiterString.toCharArray()) {
            if (!checkedDelimiter.toString().contains(String.valueOf(delimiter))) {
                checkedDelimiter.append(delimiter);
                continue;
            }
            throw new IllegalArgumentException("중복된 커스텀 구분자가 입력되었습니다.");
        }
    }

    public static void validateIllegalNumericDelimiter(String delimiterString) {
        for (char delimiter : delimiterString.toCharArray()) {
            if (Character.isDigit(delimiter)) {
                throw new IllegalArgumentException("숫자는 커스텀 구분자로 입력되지 않습니다.");
            }
        }
    }
}
