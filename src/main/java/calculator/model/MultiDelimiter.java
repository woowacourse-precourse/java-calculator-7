package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class MultiDelimiter {

    /**
     * 문자를 구분자로 나누는 메소드
     * @param str 구분자 포함된 문자 (ex) "//;\n1;2;3" 또는 "1,2:3"
     * @return 구분자로 분리된 String[]
     */
    public String[] splitWithDelimiter(String str) {
        str = str.replace("\\n", "\n");  // 리터럴 개행문자 변환

        // 기본 구분자: 쉼표와 콜론
        String defaultDelimiters = "[,|:]";

        // 사용자 정의 구분자 패턴: "//구분자\n"
        String regex = "//(.)\n(.*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        String remainingString;  // 구분자 제외한 남은 부분
        String customDelimiter = "";  // 사용자 정의 구분자

        // 사용자 정의 구분자 존재
        if (matcher.find()) {
            customDelimiter = Pattern.quote(matcher.group(1));  // 사용자 정의 구분자
            remainingString = matcher.group(2);  // 구분자를 제외한 문자
        } else {
            remainingString = str;
        }

        // 사용할 구분자 설정
        String delimiters = customDelimiter.isEmpty() ? defaultDelimiters : customDelimiter;

        try {
            return remainingString.split(delimiters);
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("문자를 구분자로 분리할 수 없습니다.", e);
        }
    }
}
