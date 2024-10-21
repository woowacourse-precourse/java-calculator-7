package calculator.calculate;

/**
 * CalculatorService 인터페이스의 구현체.
 * 숫자 배열의 합계를 계산하고, 문자열 배열을 정수 배열로 변환하는 기능을 제공합니다.
 */
public class CalculateServiceImpl implements CalculateService {
    private static final String ERROR_MESSAGE_INVALID_NUMBER = "유효하지 않은 숫자 형식입니다: ";
    private static final String ERROR_MESSAGE_NEGATIVE_OR_ZERO = "0 또는 음수는 입력할 수 없습니다: ";

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
            String numberStr = inputString[i];
            if (numberStr.isEmpty()) {
                continue;
            }
            result[i] = parseValidPositiveNumber(numberStr);
        }
        return result;
    }

    /**
     * 입력된 문자열이 유효한 양수인지 확인하고 정수로 변환합니다.
     * 유효하지 않은 경우 IllegalArgumentException을 발생시킵니다.
     *
     * @param numberStr 입력 문자열
     * @return 변환된 정수
     */
    private int parseValidPositiveNumber(String numberStr) {
        int number;
        try {
            number = Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_NUMBER + numberStr);
        }

        // 0 이하인 값은 예외 처리
        if (number <= 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NEGATIVE_OR_ZERO + numberStr);
        }

        return number;
    }
}
