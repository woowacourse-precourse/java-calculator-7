package calculator;

import java.util.ArrayList;
import java.util.List;

public class DelimiterExtractor {

    public List<Character> extract(String string) {
        List<Character> delimiters = new ArrayList<>(List.of(',', ':'));

        // 커스텀 구분자 존재 여부와 커스텀 구분자 형식 검사
        boolean hasDelimiter = validate(string);

        // 커스텀 구분자가 있는 경우
        if (hasDelimiter) {
            // 커스텀 구분자 추가
            char customDelimiter = extractCustomDelimiter(string);
            delimiters.add(customDelimiter);
        }

        return delimiters;
    }

    private char extractCustomDelimiter(String string) {
        char customDelimiter = string.charAt(2);

        // 커스텀 구분자가 숫자인지 검사
        if (Character.isDigit(customDelimiter)) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 아니어야 합니다.");
        }

        return customDelimiter;
    }

    private boolean validate(String string) {
        // 빈 문자열인 경우
        if (string.isEmpty()) {
            return false;
        }

        int customDelimiterStartIndex = string.indexOf("//");
        int customDelimiterEndIndex = string.indexOf("\\n");

        // 커스텀 구분자가 없는 경우
        if (customDelimiterStartIndex == -1 && customDelimiterEndIndex == -1) {
            return false;
        }

        // 잘못된 커스텀 구분자 형식
        if (customDelimiterStartIndex != 0 || customDelimiterEndIndex != 3) {
            throw new IllegalArgumentException(
                    "커스텀 구분자는 \"//\"으로 시작하고 \"\\n\"으로 끝나는 한 글자여야 합니다."
            );
        }

        return true;
    }

}
