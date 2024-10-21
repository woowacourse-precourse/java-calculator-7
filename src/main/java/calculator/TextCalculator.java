package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextCalculator {

    public TextCalculator() {}

    // 문자열이 유효한지 검사
    public void validateText(String inputText) {
        // 문자열에 기본 구분자와 숫자 외 다른 문자가 있는지 검사
        String textRegex = "[0-9,:]+$";
        if(inputText.matches(textRegex)) {
            return;
        }

        // 커스텀 구분자가 형식에 맞게 있는지 검사
        String customDelimiterRegex = "^//([^0-9\\\\]?)\\\\n[0-9,:]+$";
        if(!inputText.matches(customDelimiterRegex)) {
            throw new IllegalArgumentException("문자열의 형식이 올바르지 않습니다.");
        }
    }

    public int calculateSum(String inputText) {
        int sum = 0;

        String numberRegex = "\\d+";
        Pattern numberPattern = Pattern.compile(numberRegex);
        Matcher numberMatcher = numberPattern.matcher(inputText);

        while(numberMatcher.find()) {
            sum += Integer.parseInt(numberMatcher.group());
        }

        return sum;
    }

}