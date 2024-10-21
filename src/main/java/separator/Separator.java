package separator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {

    private static final String DEFAULT_DELIMITER = ",|:";

    public static String[] split(String inputString) {
        String delimiter = DEFAULT_DELIMITER;
        Matcher customDelimiterMatcher = Pattern.compile("//(.)\\\\n(.*)").matcher(inputString);

        if (customDelimiterMatcher.find()) {
            delimiter = Pattern.quote(customDelimiterMatcher.group(1)); // 커스텀 구분자 설정
            inputString = customDelimiterMatcher.group(2); // 구분자를 제외한 나머지 문자열
        }

        return inputString.split(delimiter); // 구분자를 기준으로 문자열 분리
    }
}
