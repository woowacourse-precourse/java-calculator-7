package calculator.calculator;

/**
 * CalculatorService 인터페이스의 구현체.
 * 숫자 배열의 합계를 계산하고, 문자열 배열을 정수 배열로 변환하는 기능을 제공합니다.
 */
public class CalculatorServiceImpl implements CalculatorService {

    /**
     * 주어진 숫자 배열의 합을 계산합니다.
     *
     * @param numbers 정수 배열
     * @return 배열의 모든 숫자의 합
     */
    @Override
    public int calculateSum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    @Override
    public int[] parseIntArray(String[] inputStrings) {
        return new int[0];
    }
}
