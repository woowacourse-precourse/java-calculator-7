package calculator;

import calculator.exception.ErrorMessage;
import calculator.exception.InvalidInputException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CalculatorModel {
    public static final String CUSTOM_DIVIDER_PREFIX = "//";
    public static final String CUSTOM_DIVIDER_SUFFIX = "\\n";
    public static final int CUSTOM_DIVIDER_SUFFIX_INDEX = 5;
    public static final int CUSTOM_DIVIDER_INDEX = 2;
    public static final String[] DEFAULT_DIVIDERS = {",", ":"};
    public static final String OUTPUT_FOR_BLANK_INPUT = "0";
    private List<String> dividers = new ArrayList<>(Arrays.asList(DEFAULT_DIVIDERS));

    /**
     * input 을 구분자 콤마(,) 와 콜론(:)으로 나누어 List<Integer> 로 반환한다. 커스텀 구분자를 사용 할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//" 와 "\n" 사이에 위치하고,
     * 한 글자여야 한다.
     *
     * @param input 구분할 문자열입니다.
     * @return 구분한 값들의 정수 리스트입니다.
     */
    public List<String> splitString(String input) {
        if (input.isBlank()) {
            return List.of(OUTPUT_FOR_BLANK_INPUT);
        }

        // 커스텀 구분자가 있는 경우
        if (input.startsWith(CUSTOM_DIVIDER_PREFIX)) {
            String customDivider = extractCustomDividerFromInput(input);
            dividers.add(customDivider);
            input = stripCustomDividerFromInput(input);
        }

        validateInput(input, dividers);

        return splitStringWithDividers(input, dividers);
    }

    // 커스텀 구분자 추출
    private String extractCustomDividerFromInput(String input) {
        validateCustomDividerInputFormat(input);
        String customDivider = input.substring(CUSTOM_DIVIDER_INDEX, CUSTOM_DIVIDER_INDEX + 1);
        validateCustomDividerType(customDivider);
        return customDivider;
    }

    // 커스텀 구분자 입력 형식 검증 (커스텀 구분자는 문자이고 "//[구분자]\n" 형식이어야 함)
    private void validateCustomDividerInputFormat(String customDividerInput) {
        if (!customDividerInput.startsWith(CUSTOM_DIVIDER_PREFIX)
                || !customDividerInput.startsWith(CUSTOM_DIVIDER_SUFFIX, CUSTOM_DIVIDER_INDEX + 1)) {
            throw new InvalidInputException(customDividerInput, ErrorMessage.CUSTOM_INPUT_ERROR);
        }
    }

    // 커스텀 구분자가 숫자가 아닌지 검증
    private void validateCustomDividerType(String customDivider) {
        if (Character.isDigit(customDivider.charAt(0))) {
            throw new InvalidInputException(customDivider, ErrorMessage.CUSTOM_DIVIDER_DIGIT);
        }
    }

    // 커스텀 구분자 설정 부분를 제외한 입력값 반환
    private String stripCustomDividerFromInput(String input) {
        return input.substring(CUSTOM_DIVIDER_SUFFIX_INDEX);
    }

    // 입력값 검증 (숫자와 구분자로만 이루어져야 함)
    private void validateInput(String defaultInput, List<String> dividers) {
        String dividersString = String.join("", dividers);
        System.out.println(dividersString);
        String defaultInputRegex = "^(\\d+[" + dividersString + "])*\\d+$"; // 기본값: ^(\\d+[,:])*\\d+$
        if (!Pattern.matches(defaultInputRegex, defaultInput)) {
            throw new InvalidInputException(defaultInput, ErrorMessage.INVALID_INPUT);
        }
    }

    // 구분자들로 문자열을 나누어 List 로 반환
    private List<String> splitStringWithDividers(String input, List<String> dividers) {
        String dividersRegex = String.join("|", dividers);
        String[] splitResult = input.split(dividersRegex);
        return List.of(splitResult);
    }

    /**
     * 문자열 리스트를 정수 리스트로 변환한다.
     *
     * @param numberStrings 문자열 리스트이다. 각 값은 숫자 형식이여야 한다.
     * @return 정수 리스트
     */
    public List<Integer> convertStringListToIntList(List<String> numberStrings) {
        return numberStrings.stream()
                .map(this::parseToInt)
                .toList();
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
     * @param numbers 합을 계산할 정수 리스트입니다.
     * @return 합계 값입니다.
     */
    public int calculateSum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
