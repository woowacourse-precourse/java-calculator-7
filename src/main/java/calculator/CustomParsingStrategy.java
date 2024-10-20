package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class CustomParsingStrategy implements ParsingStrategy {
    private static final String INVALID_FORMAT_ERROR = "잘못된 형식의 입력입니다.";
    private static final String EMPTY_DELIMITER_ERROR = "구분자를 입력해야 합니다.";
    private static final String INVALID_DIGIT_DELIMITER_ERROR = "1글자의 구분자는 숫자를 사용할 수 없습니다: ";
    private static final String INVALID_ALL_DIGIT_DELIMITER_ERROR = "모든 구분자가 숫자인 경우는 허용되지 않습니다: ";
    private static final String INVALID_NUMBER_INPUT_ERROR = "잘못된 문자 입력: ";
    private static final String NEGATIVE_NOT_ALLOWED_ERROR = "음수를 입력할 수 없습니다: ";

    @Override
    public int parse(String input) {
        int delimiterEnd = input.indexOf('\n');
        if (delimiterEnd == -1) {
            throw new IllegalArgumentException(INVALID_FORMAT_ERROR);
        }

        String delimiter = input.substring(2, delimiterEnd);
        validateDelimiter(delimiter);

        String numbersPart = input.substring(delimiterEnd + 1);
        String[] numbers = numbersPart.split(Pattern.quote(delimiter) + "|,|:");

        return Arrays.stream(numbers)
                .mapToInt(this::parseNumber)
                .sum();
    }

    private void validateDelimiter(String delimiter) {
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_DELIMITER_ERROR);
        }
        if (delimiter.length() == 1 && isDigit(delimiter)) {
            throw new IllegalArgumentException(INVALID_DIGIT_DELIMITER_ERROR + delimiter);
        }
        if (delimiter.matches("\\d+")) {
            throw new IllegalArgumentException(INVALID_ALL_DIGIT_DELIMITER_ERROR + delimiter);
        }
    }

    private boolean isDigit(String delimiter) {
        return delimiter.matches("\\d");
    }

    private int parseNumber(String number) {
        if (number.isEmpty()) {
            return 0;
        }
        if (!number.matches("-?\\d+")) {
            throw new IllegalArgumentException(INVALID_NUMBER_INPUT_ERROR + number);
        }
        int num = Integer.parseInt(number);
        if (num < 0) {
            throw new IllegalArgumentException(NEGATIVE_NOT_ALLOWED_ERROR + num);
        }
        return num;
    }
}
