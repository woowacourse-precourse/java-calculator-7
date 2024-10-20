package calculator.util;

import java.util.ArrayList;
import java.util.List;

public class ExtractDelimiters {
    // 커스텀 구분자와 기본 구분자를 추출하는 메서드
    public static List<String> extractDelimiters(String input) {
        List<String> delimiters = new ArrayList<>();

        // 커스텀 구분자 처리
        int index = 0;
        while (input.startsWith("//", index)) {
            int delimiterStart = index + 2;
            int delimiterEnd = input.indexOf("\\n", delimiterStart);
            if (delimiterEnd == -1) {
                break;
            }

            delimiters.add(input.substring(delimiterStart, delimiterEnd));
            index = delimiterEnd + 2;
        }

        // 기본 구분자를 리스트에 추가
        char[] DEFAULT_DELIMITERS = {',', ':'};
        for (char defaultDelimiter : DEFAULT_DELIMITERS) {
            delimiters.add(String.valueOf(defaultDelimiter));
        }

        return delimiters;
    }
}
