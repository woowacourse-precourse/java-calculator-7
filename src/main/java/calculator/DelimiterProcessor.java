package calculator;

import java.util.regex.Pattern;

public class DelimiterProcessor {
    private static final String DEFAULT_DELIMITERS = ",|:";

    public String[] process(String input) {
        // \n 처리를 먼저 수행
        input = input.replace("\\n", "\n");

        String delimiter = DEFAULT_DELIMITERS;
        String numbers = input;

        // 커스텀 구분자가 있는지 확인
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력입니다. \\n을 찾을 수 없습니다.");
            }

            String customDelimiter = Pattern.quote(input.substring(2, delimiterEndIndex));
            delimiter = customDelimiter + "|" + DEFAULT_DELIMITERS;
            numbers = input.substring(delimiterEndIndex + 1);
        }

        // 구분자로 문자열 나누기
        return numbers.split(delimiter);
    }
}