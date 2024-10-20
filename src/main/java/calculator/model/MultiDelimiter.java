package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class MultiDelimiter {

    private static final String DEFAULT_DELIMITERS = "[,|:]";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    /**
     * 문자를 구분자로 나누는 메소드
     * @param str 구분자 포함된 문자 (ex) "//;\n1;2;3" 또는 "1,2:3"
     * @return 구분자로 분리된 String[]
     */
    public String[] splitWithDelimiter(String str) {
        str = str.replace("\\n", "\n");  // 리터럴 개행문자 변환

        String[] delimiterAndRemaining = extractDelimiterAndString(str);
        String delimiters = delimiterAndRemaining[0];
        String remainingString = delimiterAndRemaining[1];

        return splitStrings(remainingString, delimiters);
    }

    /**
     * 문자열을 구분자를 사용하여 분리
     * @param remainingString 구분자를 제외한 문자열
     * @param delimiters 구분자 패턴
     * @return 구분자로 분리된 문자열
     */
    private String[] splitStrings(String remainingString, String delimiters) {
        try {
            return remainingString.split(delimiters);
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("문자를 구분자로 분리할 수 없습니다.", e);
        }
    }

    /**
     * 구분자와 구분자 제외한 문자열 추출
     * @return 구분자, 구분자 제외한 나머지 문자 배열
     */
    private String[] extractDelimiterAndString(String str) {
        String[] result = getCustomDelimiter(str);

        // 사용자 구분자 없는 경우 기본 구분자 사용
        if (result[0].isEmpty()) {
            return new String[] {DEFAULT_DELIMITERS, str};
        }

        return result;
    }

    /**
     * 커스텀 구분자 추출. 커스텀 구분자 아닌 경우 ""로 처리하여 구분
     * @param str 구분자가 포함된 문자열
     * @return 구분자, 문자 배열
     */
    private String[] getCustomDelimiter(String str) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            String delimiter = Pattern.quote(matcher.group(1));  // 사용자 정의 구분자
            String remainingString = matcher.group(2);  // 구분자를 제외한 문자
            return new String[] {delimiter, remainingString};
        }

        return new String[] {"", str};
    }

}
