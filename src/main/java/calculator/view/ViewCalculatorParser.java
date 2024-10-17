package calculator.view;

import calculator.domain.exception.CalculatorErrorMessage;
import calculator.domain.exception.CalculatorException;
import calculator.dto.request.CalculatorRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// view에서 들어오는 입력을 파싱하여 구분자와 계산하고자하는 문자열을 저장하는 CalculatorRequest로 반환하도록 하는 메서드 구현
final class ViewCalculatorParser {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final Pattern SINGLE_CHAR_DELIMITER_PATTERN = Pattern.compile("^//(.)\\\\n");
    private static final int MIN_DELIMITER_LENGTH = 5;

    static CalculatorRequest parseDelimitersAndInput(String input) {
        if (!input.startsWith(CUSTOM_DELIMITER_PREFIX) || input.length() < MIN_DELIMITER_LENGTH) {
            return CalculatorRequest.of(DEFAULT_DELIMITERS, input); // 기본 구분자 반환
        }

        Matcher matcher = SINGLE_CHAR_DELIMITER_PATTERN.matcher(input);

        if (!matcher.find()) {
            throw CalculatorException.from(CalculatorErrorMessage.INVALID_CUSTOM_DELIMITER_ERROR);
        }

        String customDelimiter = matcher.group(1);
        String remainingInput = input.substring(matcher.end()); // 구분자 선언 부분을 제거한 나머지 입력 값

        return CalculatorRequest.of(DEFAULT_DELIMITERS + "|" + Pattern.quote(customDelimiter),
                remainingInput);
    }
}
