package calculator.model;



public class SeparatorValidator {

    public static void validateCustomDelimiter(String input) {
        if (input.startsWith("//") && !input.matches("//(.)\\\\n.*")) {
            throw new IllegalArgumentException("올바르지 않은 구분자 형식입니다.");
        }
    }


    public static void validateInputEndsWithNumber(String input, String activeSeparator) {
        String[] separators = activeSeparator.split("|");
        for (String separator : separators) {
            if (input.endsWith(separator)) {
                throw new IllegalArgumentException("구분자 뒤에 숫자가 와야 합니다.");
            }
        }
    }


    public static void validateNoConsecutiveDelimiters(String input, String separator) {
        String[] separators = separator.split("|");

        for (String seperator : separators) {
            if (input.contains(seperator + seperator)) {
                throw new IllegalArgumentException("연속된 구분자는 허용되지 않습니다.");
            }
        }
    }


    public static void validateCustomDelimiterLength(String customSeparator) {
        if (customSeparator.length() != 1) {
            throw new IllegalArgumentException("구분자는 한 글자여야 합니다: " + customSeparator);
        }
    }

    public static void validateOnlyCustomDelimiterUsed(String input) {
        if (input.contains(",") || input.contains(":")) {
            throw new IllegalArgumentException("기본 구분자(쉼표 또는 콜론)와 커스텀 구분자를 혼용할 수 없습니다.");
        }
    }

    public static void validateCustomDelimiterIsNotNumber(String customSeparator) {
        if (Character.isDigit(customSeparator.charAt(0))) {
            throw new IllegalArgumentException("구분자는 숫자가 될 수 없습니다: " + customSeparator);
        }
    }




}

