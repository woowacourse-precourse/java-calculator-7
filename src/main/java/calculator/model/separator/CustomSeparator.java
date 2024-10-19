package calculator.model.separator;

import java.util.regex.Pattern;

public class CustomSeparator implements Separator {
    private final String customSeparator;
    private static final int MAX_CUSTOM_SEPARATOR_LENGTH = 1;

    public CustomSeparator(String customSeparator) {
        validateCustomSeparator(customSeparator);
        this.customSeparator = Pattern.quote(customSeparator);
    }

    @Override
    public String getSeparator() {
        return customSeparator;
    }

    public static Separator extractAndCombine(String input, String defaultSeparator) {
        int separatorIndex = input.indexOf("\\n");
        if (separatorIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
        }

        // 커스텀 구분자 추출
        String customSeparator = input.substring(input.indexOf("//") + 2, separatorIndex);
        validateCustomSeparator(customSeparator);

        // 기본 구분자와 커스텀 구분자를 결합한 새로운 정규식 생성
        String combinedSeparator = defaultSeparator + "|" + Pattern.quote(customSeparator);
        return new CombinedSeparator(combinedSeparator); // 새로운 Separator를 반환
    }

    private static void validateCustomSeparator(String customSeparator) {
        if (customSeparator.length() > MAX_CUSTOM_SEPARATOR_LENGTH) {
            throw new IllegalArgumentException("커스텀 구분자는 한 글자만 가능합니다.");
        }
        if (customSeparator.isEmpty() || customSeparator.trim().isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자는 공백이 될 수 없습니다.");
        }
        if (customSeparator.matches("\\d")) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 될 수 없습니다.");
        }
    }
}