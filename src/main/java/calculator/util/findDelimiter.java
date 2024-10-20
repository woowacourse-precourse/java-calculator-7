package calculator.util;

import java.util.List;

public class findDelimiter {
    // 주어진 위치에서 구분자를 찾는 메서드
    public static String findDelimiter(String input, int startIndex, List<String> delimiters) {
        for (String delimiter : delimiters) {
            if (input.startsWith(delimiter, startIndex)) {
                return delimiter;
            }
        }
        return null;
    }
}
