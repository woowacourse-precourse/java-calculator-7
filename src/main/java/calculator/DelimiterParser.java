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

                // 커스텀 구분자가 비어있거나 숫자일 때
                if (customDelimiter.isEmpty()) {
                    throw new IllegalArgumentException("구분자가 비어 있습니다. 유효한 구분자를 입력해주세요.");
                } else if (customDelimiter.matches("\\d+")) {
                    throw new IllegalArgumentException("구분자가 숫자일 수 없습니다. 다른 구분자를 입력해주세요.");

                }

                // "\n"뒤에 문자열이 있는지 확인
                int remainStart = delimiterEnd + 1;

                if (remainStart < input.length()) {
                    String remainString = input.substring(remainStart);
                    String finalDelimiter = Pattern.quote(customDelimiter);
                    return new String[]{finalDelimiter, remainString};

                } else {
                    throw new IllegalArgumentException("구분자 뒤에 계산할 문자열이 없습니다.");
                }

            }
        }
        return new String[]{defaultDelimiter, input};
    }
}