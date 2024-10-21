package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Separator {

    private static final String CUSTOM_DELIMITER_BEGIN = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";
    private static final String BASIC_DELIMITER_COMMA = ",";
    private static final String BASIC_DELIMITER_COLON = ":";

    // 문자열에서 구분자를 기준으로 피연산자를 추출
    public static List<String> split(String input) {
        List<String> delimiters = new ArrayList<>(Arrays.asList(BASIC_DELIMITER_COMMA, BASIC_DELIMITER_COLON));
        String trimmedInput = trimInput(input, delimiters);
        String delimiter = String.join("|", delimiters);
        return Arrays.asList(trimmedInput.split(delimiter));
    }

    // 피연산자와 구분자만 존재하도록 정돈
    private static String trimInput(String input,List<String> delimiters) {
        if (hasCustomSeparator(input)) {
            String customDelimiter = input.substring(
                    input.indexOf(CUSTOM_DELIMITER_BEGIN) + CUSTOM_DELIMITER_BEGIN.length(),
                    input.indexOf(CUSTOM_DELIMITER_END)
            );
            delimiters.add(customDelimiter);
            return input.substring(input.indexOf(CUSTOM_DELIMITER_END) + CUSTOM_DELIMITER_END.length());
        }
        return input;
    }

    // 커스텀 구분자 여부 확인
    private static boolean hasCustomSeparator(String input) {
        return input.contains(CUSTOM_DELIMITER_BEGIN) && input.contains(CUSTOM_DELIMITER_END);
    }
}
