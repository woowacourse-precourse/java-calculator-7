package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterHandler {
    // 커스텀 구분자가 있는지 확인하는 매처 반환
    public static Matcher getCustomDelimiterMatcher(String str) {
        return Pattern.compile("//(.)\\\\n(.*)").matcher(str);  // 정규식에서 '\n'은 줄바꿈으로 처리됨
    }

    // 커스텀 구분자 추출
    public static String getCustomDelimiter(Matcher matcher) {
        return matcher.group(1);
    }

    // 커스텀 구분자를 사용하여 숫자 부분 추출
    public static String getNumbersWithCustomDelimiter(Matcher matcher) {
        return matcher.group(2);
    }
}
