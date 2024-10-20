package calculator.calculate;

/**
 * CalculatorService 인터페이스의 구현체.
 * 숫자 배열의 합계를 계산하고, 문자열 배열을 정수 배열로 변환하는 기능을 제공합니다.
 */
public class CalculateServiceImpl implements CalculateService {

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

    /**
     * 문자열 배열을 정수 배열로 변환합니다.
     * 현재는 기본 구현 상태로, 추후 구현 예정입니다.
     *
     * @param inputString 문자열 배열
     * @return 정수 배열 (현재는 빈 배열 반환)
     */
    @Override
    public int[] parseIntArray(String[] inputString) {
        int[] result = new int[inputString.length];
        for (int i = 0; i < inputString.length; i++) {
            if (inputString[i].isEmpty()) {
                continue;
            }
            result[i] = Integer.parseInt(inputString[i]);
        }
        return result;
    }
}
