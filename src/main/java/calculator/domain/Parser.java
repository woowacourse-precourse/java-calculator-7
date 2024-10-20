package calculator.domain;

import static calculator.domain.Delimiter.getCustomDelimiter;

import java.util.Arrays;
import java.util.List;

public class Parser {

    // 구분자를 기준으로 문자열 split
    public static List<String> splitInput(String input) {
        String delimiter = makeDelimiter(input);

        String numbers = removeCustomDelimiterPart(input);

        return Arrays.asList(numbers.split(delimiter));
    }

    // 커스텀 구분자와 지정 구분자를 결합하여 최종 구분자 반환
    private static String makeDelimiter(String input) {
        StringBuilder delimiterBuilder = new StringBuilder("[:,");

        if (getCustomDelimiter(input) != null) {
            delimiterBuilder.append(getCustomDelimiter(input));
        }

        return delimiterBuilder.append("]").toString();
    }

    // 커스텀 구분자를 지정하는 부분을 제거한 문자열 반환
    private static String removeCustomDelimiterPart(String input) {
        if (Delimiter.getCustomDelimiter(input) != null) {
            int delimiterEndIndex = input.indexOf("\\n") + 1;

            return input.substring(delimiterEndIndex + 1);
        }

        return input;
    }
}
