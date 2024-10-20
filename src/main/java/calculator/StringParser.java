package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringParser {
    private StringParser() {

    }

    public static List<Integer> intListWithoutSeparator(String input) {
        List<Integer> result = new ArrayList<>();

        // 빈 문자열 처리
        if (input.isEmpty()) {
            result.add(0);
            return result;
        }

        String separators = "[,:]";  // 기본 구분자
        String processedInput = input;

        // 커스텀 구분자가 있는지 확인
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");

            // "\n"이 없을 경우 예외 처리
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("Invalid input: Missing newline after custom delimiter.");
            }

            // 구분자와 숫자 부분 추출
            String customDelimiter = input.substring(2, delimiterEndIndex);
            separators = Pattern.quote(customDelimiter);  // 특수 문자를 위한 처리
            processedInput = input.substring(delimiterEndIndex + 2);
        }

        String[] numberStr = processedInput.split(separators);
        for (String s : numberStr) {
            result.add(Integer.parseInt(s));
        }

        return result;
    }
}
