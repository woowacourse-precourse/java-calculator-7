package calculator.application.in;

import calculator.domain.CalculateExpression;

public interface CalculateUseCase {

    /**
     * 숫자와 구분자로 이루어진 문자열에서 숫자들의 합을 계산한다.
     *
     * @param expression 숫자와 구분자로 이루어진 문자열
     * @return 숫자들의 합
     * @throws IllegalArgumentException 잘못된 문자열 오류
     */
    Long calculate(CalculateExpression expression) throws IllegalArgumentException;
}
