package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    // 기본 구분자: , 또는 :
    private static String delimiter = "[,|:]";
    private static int result = 0;

    private static final String EMPTY_STRING = "";
    private static final String WHITESPACE = " ";
    private static final int CUSTOM_DELIMITER_ORDER = 1;
    private static final int ARITHMETIC_EXPRESSION_ORDER = 2;
    // ex) 커스텀 구분자를 ;로 정했을 때, //;\n1;2;3
    private static final String CUSTOM_REGEX = "//(.)\\\\n(.*)";

    public static int calculate(String input) {
        if (EMPTY_STRING.equals(input)) {
            return result;
        }

        if (input.contains(WHITESPACE)) {
            throw new IllegalArgumentException("입력하신 문자열에는 공백이 포함될 수 없습니다.");
        }

        input = extractByCustomDelimiter(input);

        String[] numbers = input.split(delimiter);
        for (String number : numbers) {
            if (EMPTY_STRING.equals(number)) {
                throw new IllegalArgumentException("구분자 사이에는 숫자가 입력되어야 합니다.");
            }

            int operand = Integer.parseInt(number);
            if (operand < 0) {
                throw new IllegalArgumentException(
                        String.format("(%s)는 음수입니다. 입력하는 숫자들은 반드시 양수 혹은 0이어야 합니다.", operand)
                );
            }
            result += operand;
        }
        return result;
    }

    private static String extractByCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            delimiter = matcher.group(CUSTOM_DELIMITER_ORDER);
            input = matcher.group(ARITHMETIC_EXPRESSION_ORDER);
        }
        return input;
    }
}
