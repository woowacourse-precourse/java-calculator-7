package calculator;

import java.util.Arrays;

public class CustomDelimiterStrategy implements DelimiterStrategy {

    @Override
    public String[] splitNumbers(String input) {
        String[] parts = input.split("\\\\n", 2);
        System.out.println(Arrays.toString(parts));
        if (parts.length < 2) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
        }

        String customDelimiter = escapeSpecialCharacters(parts[0].substring(2));
        String combinedDelimiters = customDelimiter + "|[,:]";
        return parts[1].split(combinedDelimiters);
    }

    @Override
    public boolean matches(String input) {
        // 입력이 "//"로 시작하면 사용자 정의 구분자로 처리
        return input.startsWith("//");
    }

    private String escapeSpecialCharacters(String delimiter) {
        return delimiter.replaceAll("([\\[\\]{}()*+?^$|])", "\\\\$1");
    }
}
