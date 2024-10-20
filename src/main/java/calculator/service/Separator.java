package calculator.service;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Separator {
    private static final String BASIC_SEPARATOR_COMMA = ",";
    private static final String BASIC_SEPARATOR_COLON = ":";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.+)\\\\n");

    public int[] separate(String content) {
        if (isCustomSeparator(content)) {
            return customSeparate(content);
        }
        return basicSeparate(content);
    }

    private boolean isCustomSeparator(String content) {
        return content.startsWith("//") && content.contains("\\n");
    }

    private int[] basicSeparate(String content) {
        validateContent(content);
        String[] splitedContent = content.replaceAll(BASIC_SEPARATOR_COLON, BASIC_SEPARATOR_COMMA)
                .split(BASIC_SEPARATOR_COMMA);
        return Arrays.stream(splitedContent).mapToInt(this::convertToNumber).toArray();
    }

    private void validateContent(String content) {
        if (content.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 비어있는 문자열 입니다.");
        }
        if (!Character.isDigit(content.charAt(0)) || !Character.isDigit(content.charAt(content.length() - 1))) {
            throw new IllegalArgumentException("[ERROR] 시작과 끝은 숫자여야 합니다.");
        }
    }

    private int[] customSeparate(String contentWithCustomSeparator) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(contentWithCustomSeparator);
        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            String content = contentWithCustomSeparator.substring(matcher.end());
            validateContent(content);
            String[] splitedContent = splitByCustomSeparator(content, customSeparator);
            return Arrays.stream(splitedContent).mapToInt(this::convertToNumber).toArray();
        }
        throw new IllegalArgumentException("[ERROR] Separator: 타당하지 않은 형식의 커스텀 구분자");
    }

    private String[] splitByCustomSeparator(String content, String customSeparator) {
        try {
            return content.split(customSeparator);
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("[ERROR] Separator: 타당하지 않은 형식의 커스텀 구분자!");
        }
    }

    private int convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] Separator: 숫자로 변환할 수 없는 값입니다.");
        }
    }

}
