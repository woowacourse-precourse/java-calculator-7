package calculator.util.validator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.util.constant.Constants.*;

public class InputValidator {

    // 정적 메서드를 통해 객체 생성 없이 검증을 수행
    public static void validate(String input) {
        validateBlank(input);
        validateEndWord(input);
        validateStartWord(input);
        validateDelimiters(input);
    }

    private static void validateBlank(String input) {
        if (Objects.isNull(input) || input.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "공백을 입력할 수 없습니다.");
        }
    }

    private static void validateEndWord(String input) {
        if (input.endsWith(DELIMITER_COMMA) || input.endsWith(DELIMITER_COLON)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "구분자로 끝날 수 없습니다.");
        }
    }

    private static void validateStartWord(String input) {
        if (input.startsWith(DELIMITER_COMMA) || input.startsWith(DELIMITER_COLON)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "구분자로 시작할 수 없습니다.");
        }
    }
    private static void validateDelimiters(String input) {
        String delimiter = DEFAULT_DELIMITER_PATTERN;
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            delimiter = matcher.group(1);
            input = matcher.group(2);
        }

        String[] parts = input.split("[,:" + delimiter + "]");

        for (String part : parts) {
            if (!part.matches(SINGLE_NUMBER_PATTERN)) {
                throw new IllegalArgumentException(ERROR_MESSAGE + "유효하지 않은 구분자입니다.");
            }
        }
    }





}
