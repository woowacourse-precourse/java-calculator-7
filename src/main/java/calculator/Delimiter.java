package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    // 기본 구분자: 쉼표(,) 또는 콜론(:)
    private static final String DEFAULT_DELIMITERS = ",|:";
    // 커스텀 구분자: 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자
    private static final String CUSTOM_DELIMITER_PATTERN = "^//(.*?)\\\\n(.*)";

    public static String[] split(String input) {
        // 커스텀 구분자 패턴과 일치하는지 확인
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            // 커스텀 구분자로 분리
            String customDelimiter = Pattern.quote(matcher.group(1));
            String numbersPart = matcher.group(2);
            return numbersPart.split(customDelimiter);
        }
        // 기본 구분자로 분리
        return input.split(DEFAULT_DELIMITERS);
    }
}