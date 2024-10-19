package calculator.domain.parser;

import calculator.domain.dto.InputRequest;
import calculator.domain.validation.InputParserValidator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class InputParser {
    private InputParser() {
    }

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";

    /**
     * 주어진 입력 문자열에서 구분자와 계산해야 할 문자열을 자른다.
     *
     * @param input 입력 문자열
     * @return InputRequest 객체로 구분자와 입력을 포함
     */
    public static InputRequest parseDelimiterAndInput(String input) {
        InputParserValidator.checkForEmptyInput(input);
        String trimmedText = InputParserValidator.removeLeadingAndTrailingSpaces(input);

        // 사용자 정의 구분자가 없는 경우 기본 구분자로 반환
        if (!trimmedText.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return InputRequest.of(DEFAULT_DELIMITER, trimmedText);
        }

        Matcher matcher = InputParserValidator.validateCustomDelimiter(trimmedText);

        String customDelimiter = matcher.group(1);
        String targetInput = input.substring(matcher.end());

        InputParserValidator.validateDelimiter(customDelimiter);
        return InputRequest.of(DEFAULT_DELIMITER + "|" + Pattern.quote(customDelimiter),
                targetInput);
    }

}
