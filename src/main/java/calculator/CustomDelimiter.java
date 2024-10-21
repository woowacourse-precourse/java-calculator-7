package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter {
    private static List<String> customDelimiterList = new ArrayList<>();
    private static final Pattern PATTERN = Pattern.compile("//(.*?)\\\\n");

    private static void extractValues(String customDelimiterAssign) {
        Matcher matcher = PATTERN.matcher(customDelimiterAssign);

        // 정규식 패턴에 매칭되는 모든 문자열을 리스트에 추가
        while (matcher.find()) {
            customDelimiterList.add(matcher.group(1)); // customDelimiter
        }
    }

    public static List<String> getCustomDelimiterList(String customDelimiterAssign) {
        extractValues(customDelimiterAssign);
        return customDelimiterList;
    }
}