package calculator.parser;

import calculator.dto.InputRequest;
import calculator.error.CustomException;
import calculator.message.ErrorMessage;
import calculator.validation.InputValidator;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    // 입력 문자열에서 구분자와 숫자 분리
    public static InputRequest parseDelimiterAndInput(String input) {
        InputValidator.checkForEmptyInput(input);

        return Optional.of(input)
                .filter(s -> s.startsWith(DelimiterPattern.CUSTOM_DELIMITER_PREFIX.getValue()))
                .map(InputParser::parseCustomDelimiter)
                .orElseGet(() -> parseDefaultDelimiter(input));
    }

    // 커스텀 구분자 파싱 후 입력 객체 생성
    private static InputRequest parseCustomDelimiter(String input) {
        Matcher matcher = InputValidator.validateCustomDelimiter(input);
        String customDelimiter = matcher.group(1);
        String targetInput = input.substring(matcher.end());

        InputValidator.validateDelimiter(customDelimiter);
        return InputRequest.of(DelimiterPattern.DEFAULT_DELIMITER.getValue() + "|" + Pattern.quote(customDelimiter), targetInput);
    }

    // 기본 구분자를 사용하여 입력 객체 생성
    private static InputRequest parseDefaultDelimiter(String input) {
        return Optional.of(input)
                .filter(s -> !s.isEmpty() && Character.isDigit(s.charAt(0)))
                .map(s -> InputRequest.of(DelimiterPattern.DEFAULT_DELIMITER.getValue(), s))
                .orElseThrow(() -> CustomException.from(ErrorMessage.INVALID_INPUT));
    }
}
