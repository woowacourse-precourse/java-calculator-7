package calculator.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringSplitter {
    private String input;

    public StringSplitter(String input) {
        this.input = input;
    }

    public List<String> split(String delimiter) {
        if (input.startsWith("//")) {
            int newLineIndex = input.indexOf("\\n");
            if (newLineIndex == -1) {
                throw new IllegalArgumentException("올바른 형식의 커스텀 구분자를 입력해 주세요.");
            }
            String customDelimiter = input.substring(2, newLineIndex);
            String numbers = input.substring(newLineIndex + 2); // "\\n" 다음부터 시작
            return Arrays.asList(numbers.split(Pattern.quote(customDelimiter)));
        }
        return Arrays.asList(input.split(delimiter));
    }
}