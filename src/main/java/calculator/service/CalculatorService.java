package calculator.service;

public interface CalculatorService {

    /**
     * 주어진 문자열에서 숫자를 추출하여 덧셈을 수행합니다.
     *
     * @param numbers 계산할 문자열
     * @return 덧셈 결과
     */
    int calculate(int[] numbers);
}