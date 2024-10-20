package calculator;

public class CustomDelimiter {
    private static String result = "";
    private static String customDelimiter = "";
    private static final int LENGTH_OF_CUSTOM_DELIMITER_EXPRESSION = "//?\n".length();
    private static final int INDEX_OF_CUSTOM_DELIMITER = "//?\n".indexOf("?");
    private static final String[] META_CHARACTERS = {".", "*", "+", "?", "|", "^", "$", "(", ")", "[", "]", "{", "}", "\\"};

    public static String extractCustomDelimiter(String input) {
        if (isValidExpression(input)) {
            customDelimiter = input.substring(2, 3);

            customDelimiter = escapeMetaCharacters(customDelimiter);
            result = input.substring(LENGTH_OF_CUSTOM_DELIMITER_EXPRESSION + 1);
            return result;
        }

        if (Character.isDigit(Integer.parseInt(customDelimiter))) {
            throw new IllegalArgumentException("커스텀 구분자로 숫자가 입력되었습니다.");
        }

        return result;
    }

    public static boolean isValidExpression(String input) {
        if (input.contains("\\n")) {
            return true;
        }

        if (!isValidExpressionLength(input)) {
            throw new IllegalArgumentException("커스텀 구분자 표현이 잘못되었습니다.");
        }

        throw new IllegalArgumentException();
    }

    private static boolean isValidExpressionLength(String input) {
        return input.substring(0, input.indexOf("\n") + 1).length() == LENGTH_OF_CUSTOM_DELIMITER_EXPRESSION;
    }

    private static String escapeMetaCharacters(String customDelimiter) {
        for (String metaChar : META_CHARACTERS) {
            if (customDelimiter.equals(metaChar)) {
                return "\\" + customDelimiter;  // 메타 문자가 있다면 이스케이프 처리
            }
        }
        return customDelimiter;
    }


    public static String getResult() {
        return result;
    }

    public static String getCustomDelimiter() {
        return customDelimiter;
    }
}
