package calculator.utils;

import java.util.regex.Pattern;

public class StringParser {
    public static String[] parse(String input) {
        input = input.trim();
        String delimiter = "[,:]";

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            // 줄바꿈 문자를 문자로 인식하도록 "\n"을 "\\\\n"으로 변경
            String[] parts = input.split("\\\\n", 2);

            if (parts.length != 2) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }

            String customDelimiter = parts[0].substring(2);
            delimiter += "|" + Pattern.quote(customDelimiter);
            input = parts[1];
        }

        String[] numbers = input.split(delimiter);
        return numbers;
    }
}
