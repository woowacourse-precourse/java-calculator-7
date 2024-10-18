package calculator.domain.parser;

import calculator.domain.error.InputException;
import calculator.domain.message.ErrorMessage;
import calculator.domain.validation.InputValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CalculatorParser {
    private final InputValidator inputValidator;

    private static final String DELIMITER_END_MARKER = "\\n";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";

    public CalculatorParser() {
        this.inputValidator = new InputValidator();
    }

    /**
     * 사용자 입력 문자열을 파싱하여 숫자를 추출합니다.
     *
     * @param input 처리할 입력 문자열
     * @return 파싱된 숫자 문자열 리스트
     */
    public List<Integer> parse(String input) {
        String processedInput = trimAndValidateInput(input);
        String customDelimiter = extractCustomDelimiter(processedInput).orElse("");
        processedInput = replaceCustomDelimiter(processedInput, customDelimiter);

        return splitAndTrimNumbers(processedInput);
    }

    /**
     * 입력 문자열의 양쪽 공백을 제거하고, null인지 검증합니다.
     *
     * @param input 검증 및 공백 제거할 입력 문자열
     * @return 공백이 제거된 문자열
     * @throws IllegalArgumentException 입력 문자열이 null인 경우 예외 발생
     */
    private String trimAndValidateInput(String input) {
        inputValidator.checkForEmptyInput(input);
        return inputValidator.removeLeadingAndTrailingSpaces(input);
    }

    /**
     * 커스텀 구분자를 추출합니다.
     *
     * @param input 처리할 입력 문자열
     * @return 추출된 커스텀 구분자, 없으면 Optional.empty()
     */
    private Optional<String> extractCustomDelimiter(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterEndIndex = input.indexOf(DELIMITER_END_MARKER);
            return Optional.of(input.substring(2, delimiterEndIndex));
        }
        return Optional.empty();
    }

    /**
     * 커스텀 구분자를 통일된 구분자로 대체합니다.
     *
     * @param input           처리할 입력 문자열
     * @param customDelimiter 커스텀 구분자
     * @return 커스텀 구분자가 대체된 문자열
     */
    private String replaceCustomDelimiter(String input, String customDelimiter) {
        if (customDelimiter != null && !customDelimiter.isEmpty()) {
            int delimiterEndIndex = input.indexOf(DELIMITER_END_MARKER) + 2;
            String mainPart = input.substring(delimiterEndIndex);
            return mainPart.replace(customDelimiter, ",");
        }
        return input;
    }

    /**
     * 숫자 문자열을 쉼표로 분리하고 공백을 제거합니다.
     *
     * @param input 처리할 입력 문자열
     * @return 파싱된 숫자 문자열 리스트
     */
    private List<Integer> splitAndTrimNumbers(String input) {
        String[] numbers = input.split("[,:]");
        List<Integer> result = new ArrayList<>();
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new InputException(ErrorMessage.POSITIVE_INPUT_REQUIRED);
            }
            result.add(num);
        }
        return result;
    }
}
