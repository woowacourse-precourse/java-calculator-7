package calculator.model;

import calculator.global.error.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DelimiterExtractor {

    private static final String DEFAULT_DELIMITERS = ",|:";

    public String getDelimiters(String input) {

    if(input.startsWith("//")) {
        int delimiterEndIndex = input.indexOf("\n");
        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_DELIMITER_IS_NOT_DEFINED_PROPERLY.getMessage());
        }
        // 구분자 부분 추출 및 설정
        String delimitersPart = input.substring(2, delimiterEndIndex);
        return extractCustomDelimiters(delimitersPart);
    }
    return DEFAULT_DELIMITERS;

}


    // 커스텀 구분자 추출
    private String extractCustomDelimiters(String delimitersPart) {
        List<String> delimiters = new ArrayList<>();
        for (int i = 0; i < delimitersPart.length(); i++) {
            char delimiter = delimitersPart.charAt(i);
            delimiters.add(Pattern.quote(Character.toString(delimiter)));
        }
        return String.join("|", delimiters);
    }
}
