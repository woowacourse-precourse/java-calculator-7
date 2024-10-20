package calculator.model;

import calculator.error.CustomException;
import calculator.error.ErrorCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Extractor {

    private List<String> delimiters;

    // 기본 구분자 및 커스텀 구분자 추가
    public Extractor(String input) {
        this.delimiters = new ArrayList<>(List.of(",", ":"));
        extractCustomDelimiter(input).ifPresent(delimiters::add);
    }

    // 입력에서 숫자 추출
    public List<Long> extractNumbers(String input) {
        String processedInput = trimAndValidateInput(input);
        String customDelimiter = extractCustomDelimiter(processedInput).orElse("");
        processedInput = addCustomDelimiter(processedInput, customDelimiter);
        return splitAndTrimNumbers(processedInput);
    }

    // 입력값 공백 제거 후 유효성 검사
    private String trimAndValidateInput(String input) {
        return Optional.of(input)
                .filter(s -> !s.isBlank())
                .map(String::trim)
                .orElseThrow(() -> new CustomException(ErrorCode.EMPTY_INPUT));
    }

    // 커스텀 구분자 추출
    private Optional<String> extractCustomDelimiter(String input) {
        return Optional.of(input)
                .filter(this::hasCustomDelimiter)
                .map(str -> {
                    int delimiterStart = str.indexOf("//") + 2;
                    int delimiterEnd = str.indexOf("\\n");
                    if (delimiterEnd == -1) {
                        throw new CustomException(ErrorCode.MISSING_CUSTOM_DELIMITER_END);
                    }
                    String customDelimiter = str.substring(delimiterStart, delimiterEnd);
                    validateCustomDelimiter(customDelimiter);
                    return customDelimiter;
                });
    }

    // 커스텀 구분자로 숫자가 추가된 경우 예외처리
    private void validateCustomDelimiter(String delimiter) {
        if (delimiter.chars().anyMatch(Character::isDigit)) {
            throw new CustomException(ErrorCode.MISSING_CUSTOM_DELIMITER_END);
        }
    }

    // 커스텀 구분자 수가
    private String addCustomDelimiter(String input, String customDelimiter) {
        return Optional.of(customDelimiter)
                .filter(delimiter -> !delimiter.isEmpty())
                .map(delimiter -> {
                    int delimiterEndIndex = input.indexOf("\\n") + 2;
                    String mainPart = input.substring(delimiterEndIndex);
                    return mainPart.replace(delimiter, ","); // 구분자는 쉼표로 바꿔 구분
                })
                .orElse(input);
    }

    private List<Long> splitAndTrimNumbers(String input) {
        String[] numbers = input.split("[,:]");
        List<Long> result = new ArrayList<>();
        for (String number : numbers) {
            number = number.trim();
            validateDigit(number);
            validateNumberPositive(number);
            result.add(Long.parseLong(number));
        }
        return result;
    }

    // 입력에 커스텀 구분자가 있는지 확인
    private boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    // 숫자인지 여부를 검증
    private void validateDigit(String s) {
        Optional.of(s)
                .map(Long::parseLong)
                .orElseThrow(() -> new CustomException(ErrorCode.INVALID_NUMBER_FORMAT));
    }

    // 숫자가 양수인지 검증
    private void validateNumberPositive(String s) {
        if (Long.parseLong(s) <= 0) {
            throw new CustomException(ErrorCode.NOT_ALLOWED_NEGATIVE_NUMBER);
        }
    }
}
