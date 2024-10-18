package calculator.application.service;

import calculator.application.in.CalculateUseCase;
import calculator.domain.CalculateExpression;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculateService implements CalculateUseCase {

    public CalculateService() {
    }

    @Override
    public Long calculate(CalculateExpression expression) throws IllegalArgumentException {
        List<Long> numbers = this.parseNumber(expression);

        return this.sum(numbers);
    }

    /**
     * 구분자를 정규표현식으로 변환한다.
     *
     * @param delimiters 구분자 리스트
     * @return 구분자 정규표현식
     */
    private String makeDelimiterRegex(List<String> delimiters) {
        return String.join("|", delimiters);
    }

    /**
     * 문자열을 구분자로 나누고 숫자를 찾아서 반환한다.
     *
     * @param expression 사용자 문자열
     * @return 문자열에서 찾은 숫자 리스트
     * @throws IllegalArgumentException 잘못된 문자열 오류
     */
    private List<Long> parseNumber(CalculateExpression expression) throws IllegalArgumentException {
        String delimiterRegex = makeDelimiterRegex(expression.getDelimiters());

        return Arrays.stream(expression.getExpression().split(delimiterRegex))
                .map(String::trim)
                .map(this::parseAndValidNumber)
                .collect(Collectors.toList());
    }

    /**
     * 문자에서 유효한 숫자를 검사 및 추출한다.
     *
     * @param token 문자
     * @return 추출한 숫자
     * @throws IllegalArgumentException 숫자가 아니거나, 잘못된 구분자 또는 음수를 사용한 오류
     */
    private Long parseAndValidNumber(String token) throws IllegalArgumentException {
        try {
            long value = Long.parseLong(token);
            if (value < 0) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");
        }
    }

    /**
     * 숫자들을 합산한다.
     *
     * @param numbers 숫자 리스트
     * @return 숫자 리스트의 합
     */
    private Long sum(List<Long> numbers) {
        return numbers.stream()
                .mapToLong(Long::longValue)
                .sum();
    }
}
