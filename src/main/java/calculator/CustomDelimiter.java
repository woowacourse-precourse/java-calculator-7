package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter {
    private static final Pattern PATTERN = Pattern.compile("//(.*?)\\\\n");

    public static List<String> getCustomDelimiterList(String customDelimiterAssign) {
        List<String> customDelimiterList = new ArrayList<>();
        extractValues(customDelimiterAssign, customDelimiterList);
        return customDelimiterList;
    }

    private static void extractValues(String customDelimiterAssign, List<String> customDelimiterList) {
        Matcher matcher = PATTERN.matcher(customDelimiterAssign);

        // 정규식 패턴에 매칭되는 모든 문자열을 찾음
        while (matcher.find()) {
            String delimiter = matcher.group(1);
            validateDelimiter(delimiter); // 구분자 유효성 검사
            customDelimiterList.add(delimiter);
        }
    }

    private static void validateDelimiter(String delimiter) {
        if (delimiter.matches("\\d+")) {
            throw new IllegalArgumentException("숫자를 커스텀 구분자로 사용할 수 없습니다.");
        }

        if (delimiter.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 한 글자로 입력되어야 합니다.");
        }
    }
}