package calculator.model.separator;

import calculator.exception.ErrorCode;
import java.util.regex.Pattern;

public class CustomSeparator implements Separator {
    private final String customSeparator;
    private static final int MAX_CUSTOM_SEPARATOR_LENGTH = 1;
    private static final String CUSTOM_SEPARATOR_START = "//";
    private static final String CUSTOM_SEPARATOR_END = "\\n";

    public CustomSeparator(String customSeparator) {
        validateCustomSeparator(customSeparator);
        this.customSeparator = Pattern.quote(customSeparator);
    }

    public static String getStartOfSeparator() {
        return CUSTOM_SEPARATOR_START;
    }

    public static String getEndOfSeparator() {
        return CUSTOM_SEPARATOR_END;
    }

    @Override
    public String getSeparator() {
        return customSeparator;
    }

    public static Separator extractAndCombine(String input, String defaultSeparator) {
        int separatorIndex = input.indexOf(CUSTOM_SEPARATOR_END);
        if (separatorIndex == -1) {
            throw new IllegalArgumentException(ErrorCode.INVALID_CUSTOM_SEPARATOR.getMessage());
        }

        // 커스텀 구분자 추출
        String customSeparator = input.substring(input.indexOf(CUSTOM_SEPARATOR_START) + 2, separatorIndex);
        validateCustomSeparator(customSeparator);

        // 기본 구분자와 커스텀 구분자를 결합한 새로운 정규식 생성
        String combinedSeparator = defaultSeparator + "|" + Pattern.quote(customSeparator);
        return new CombinedSeparator(combinedSeparator); // 새로운 Separator를 반환
    }

    private static void validateCustomSeparator(String customSeparator) {
        if (customSeparator.length() > MAX_CUSTOM_SEPARATOR_LENGTH) {
            throw new IllegalArgumentException(ErrorCode.INVALID_CUSTOM_SEPARATOR_LENGTH.getMessage());
        }
        if (customSeparator.isEmpty() || customSeparator.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.BLANK_CUSTOM_SEPARATOR.getMessage());
        }
        if (customSeparator.matches("\\d")) {
            throw new IllegalArgumentException(ErrorCode.NUMERIC_CUSTOM_SEPARATOR.getMessage());
        }
    }
}