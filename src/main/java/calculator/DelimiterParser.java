package calculator;

import java.util.regex.Pattern;

public class DelimiterParser {
    // 구분자 추출
    public static String[] getDelimiter(String input) {
        String defaultDelimiter = ",|:";

        if (input.startsWith("//") && input.contains("\n")) {
            int delimiterStart = input.indexOf("//") + 2;
            int delimiterEnd = input.indexOf("\n");

            if (delimiterStart < delimiterEnd) {
                String customDelimiter = input.substring(delimiterStart, delimiterEnd);

                // "\n"뒤에 문자열이 있는지 확인
                int remainStart = delimiterEnd + 1;
                
                return new String[]{Pattern.quote(customDelimiter), input.substring(remainStart)};

            }
        }

        return new String[]{defaultDelimiter, input};
    }
}