package calculator;

import java.util.Arrays;

public class StringCalculator {
    private final CustomDelimiterParser parser;
    private final NumberValidator validator;

    public StringCalculator() {
        this.parser = new CustomDelimiterParser();
        this.validator = new NumberValidator();
    }

    /**
     * 주어진 입력 문자열에 대해 덧셈 연산을 수행합니다.
     *
     * @param input 계산할 숫자들이 포함된 문자열
     * @return 모든 숫자의 합
     * @throws IllegalArgumentException 입력이 유효하지 않거나 계산 중 오류 발생 시
     */
    public long calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 문자열이 null이거나 비어 있습니다.");
        }
        String[] numbers = parser.parse(input);
        return calculateNumbers(numbers);
    }

    /**
     * 파싱된 숫자 문자열 배열의 합을 계산합니다.
     *
     * @param numbers 계산할 숫자들의 문자열 배열
     * @return 모든 유효한 숫자의 합
     */
    private long calculateNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .filter(s -> !s.isEmpty())
                .mapToLong(validator::validateAndParse)
                .sum();
    }
}
