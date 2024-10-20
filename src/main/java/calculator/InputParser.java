package calculator;

public record InputParser(String text, String delimiter) {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final String DEFAULT_DELIMITERS = "[,:]";

    public String[] split() {
        return text.split(delimiter);
    }

    public static InputParser from(String input) {
        if (!hasCustomDelimiter(input)) {
            return new InputParser(input, DEFAULT_DELIMITERS);
        }
        return parseCustomDelimiter(input);
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.length() >= 5 && input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private static InputParser parseCustomDelimiter(String input) {
        int suffixIndex = getSuffixIndex(input);
        String customDelimiter = extractCustomDelimiter(input, suffixIndex);
        validateCustomDelimiter(customDelimiter);
        return createParser(input, suffixIndex, customDelimiter);
    }

    private static int getSuffixIndex(String input) {
        int suffixIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        if (suffixIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
        }
        return suffixIndex;
    }

    private static String extractCustomDelimiter(String input, int suffixIndex) {
        return input.substring(CUSTOM_DELIMITER_PREFIX.length(), suffixIndex);
    }

    private static void validateCustomDelimiter(String delimiter) {
        if (delimiter.length() != 1 || Character.isDigit(delimiter.charAt(0))) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 아닌 한 글자여야 합니다.");
        }
    }

    private static InputParser createParser(String input, int suffixIndex, String customDelimiter) {
        String numberPart = input.substring(suffixIndex + CUSTOM_DELIMITER_SUFFIX.length());
        String combinedDelimiter = String.format("[%s,:]", customDelimiter);
        return new InputParser(numberPart, combinedDelimiter);
    }
}
