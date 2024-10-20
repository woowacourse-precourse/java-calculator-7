package calculator;

import java.util.regex.Pattern;

public class CustomDelimiterStrategy implements DelimiterStrategy{
    private String delimiters = ",|:";
    @Override
    public String[] split(String input) {
        int newLineIndex = input.indexOf("\\n");
        if (newLineIndex == -1){
            throw new IllegalArgumentException();
        }

        // 커스텀 구분자 추출
        String customDelimiter = input.substring(2, newLineIndex - 1);
        delimiters = delimiters + "|" + Pattern.quote(customDelimiter); // 특수문자 고려한 구분자 처리
        input = input.substring(newLineIndex + 2);

        return input.split(delimiters);
    }
}
