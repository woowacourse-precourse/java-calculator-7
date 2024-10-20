package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


// 입력 문자열에서 구문자를 추출하는 클래스
public class ExtractDelimiter {
    // 구분자 추출
    static String extract_basic_delimiter(String input) {
        String regex = "//(.+)\\n";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return extract_custom_delimiter(matcher);
        }
        return "[,:]";
    }

    // 커스텀 구분자 추출
    static String extract_custom_delimiter(Matcher matcher) {
        String delimiter = matcher.group(1); // 커스텀 구분자 추출
        return Pattern.quote(delimiter); // 커스텀 구분자에 대해 이스케이프 처리
    }
}
