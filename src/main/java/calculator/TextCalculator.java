package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextCalculator {

    public TextCalculator() {}

    // 문자열이 유효한지 검사
    public void validateText(String inputText) {
        String customDelimiterRegex = "^//([^0-9\\\\]*)\\\\n";
        Pattern customDelimiterPattern = Pattern.compile(customDelimiterRegex);
        Matcher customDelimiterMatcher = customDelimiterPattern.matcher(inputText);

        // 문자열 앞에 커스텀 구분자 선언이 있을 경우
        if(customDelimiterMatcher.find()) {
            if(customDelimiterMatcher.group(1).length() > 1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다");
            }
        }

        String textRegex = "^[0-9,:]+$";

        // 문자열에 기본 구분자와 숫자 외 다른 문자가 있을 경우
        if(!inputText.matches(textRegex)) {
            throw new IllegalArgumentException("문자열의 형식이 올바르지 않습니다.");
        }
    }

}