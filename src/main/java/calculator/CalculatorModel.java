package calculator;

import calculator.exception.ErrorMessage;
import calculator.exception.InvalidInputException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CalculatorModel {
    public static final String[] DEFAULT_DIVIDERS = {",", ":"};
    private List<String> dividers = new ArrayList<>(Arrays.asList(DEFAULT_DIVIDERS));

    /**
     * input 을 구분자 콤마(,) 와 콜론(:)으로 나누어 List<Integer> 로 반환한다.
     * 커스텀 구분자를 사용 할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//" 와 "\n" 사이에 위치하고, 한 글자여야 한다.
     *
     * @param input 구분할 문자열입니다.
     * @return 구분한 값들의 정수 리스트입니다.
     */
    public List<Integer> splitString(String input) {
        if (input == null || input.isBlank()) {
            return List.of(0);
        }

        input = extractCustomDividerFromInput(input, dividers);
        validateInput(input, dividers);

        return splitStringWithDividers(input, dividers).stream()
                .map(this::parseToInt)
                .toList();
    }

    // 커스텀 구분자 추출 및 input 에서 커스텀 구분자 부분 삭제
    private String extractCustomDividerFromInput(String input, List<String> dividers) {
        if (input.startsWith("/")) {
            validateCustomDividerInput(input);
            dividers.add(input.substring(2, 3));
            input = input.substring(5);
        }
        return input;
    }

    // 커스텀 구분자 입력 형식 검증 (커스텀 구분자는 "//[구분자]\n" 형식이어야 함)
    private void validateCustomDividerInput(String customDividerInput) {
        if (!customDividerInput.startsWith("//") || !customDividerInput.startsWith("\\n", 3)) {
            throw new InvalidInputException(customDividerInput, ErrorMessage.CUSTOM_INPUT_ERROR);
        }
    }

    // 입력값 검증 (숫자와 구분자로만 이루어져야 함)
    private void validateInput(String defaultDividerInput, List<String> dividers) {
        String dividersString = String.join("", dividers);
        String regex = "^(\\d+[,:" + dividersString + "])*\\d+$";
        if (!Pattern.matches(regex, defaultDividerInput)) {
            throw new InvalidInputException(defaultDividerInput, ErrorMessage.INVALID_INPUT);
        }
    }

    // 구분자들로 문자열을 나누어 List 로 반환
    private List<String> splitStringWithDividers(String input, List<String> dividers) {
        return List.of(input.split(String.join("|", dividers)));
    }

    // 문자열을 정수로 변환, NumberFormatException 예외를 InvalidInputException 으로 변환
    private int parseToInt(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new InvalidInputException(value, ErrorMessage.NOT_A_NUMBER_INPUT);
        }
    }

    /**
     * values 의 합을 반환한다.
     *
     * @param values 합을 계산할 정수 리스트입니다.
     * @return 합계 값입니다.
     */
    public int calculateSum(List<Integer> values) {
        return values.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
