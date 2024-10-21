package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDelimiter {

    private static final String DEFAULT_DELIMITER = ",|:";
    // 여러 글자의 커스텀 구분자를 허용하도록 수정
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.*?)\\n(.*)";

    public static String[] parse(String input) {
        if (isEmptyInput(input)) {
            return new String[]{"0"};
        }

        if (hasCustomDelimiter(input)) {
            return splitWithCustomDelimiter(input);
        }

        return splitWithDefaultDelimiter(input);
    }

    // 입력이 비어 있는지 확인
    private static boolean isEmptyInput(String input) {
        return input == null || input.isEmpty();
    }

    // 커스텀 구분자가 있는지 확인
    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    // 커스텀 구분자로 분리하는 메서드
    private static String[] splitWithCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다. 구분자와 숫자 부분을 구분하는 \\n이 필요합니다.");
        }

        String customDelimiter = matcher.group(1); // 그룹 1에서 커스텀 구분자 가져오기
        String numbersPart = matcher.group(2); // 숫자 부분 가져오기
        return numbersPart.split(customDelimiter); // 커스텀 구분자로 숫자 분리
    }

    // 기본 구분자로 분리하는 메서드
    private static String[] splitWithDefaultDelimiter(String input) {
        return input.split(DEFAULT_DELIMITER);
    }
}
