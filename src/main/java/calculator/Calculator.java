package calculator;


/**
 * 계산기의 기본 기능을 정의하는 추상 클래스입니다.
 * 이 클래스는 모든 구체적인 계산기 클래스의 기본, 공통 로직을 제공
 */
public abstract class Calculator {
    protected String input;

    protected Calculator(String input) {
        this.input = input;
    }

    /**
     * 입력된 문자열을 계산하는 추상 메서드
     * 이 메서드는 각 구체적인 계산기 클래스에서 구현되어야 합니다.
     *
     * @return 계산 결과 정수값
     */
    public abstract int calculate();

    /**
     * 문자열 배열의 각 요소를 정수로 변환하고 양수만 더합니다.
     *
     * @param parts 합산할 숫자들이 담긴 문자열 배열
     * @return 양수들의 합
     * @throws IllegalArgumentException 음수가 입력된 경우
     * @throws IllegalArgumentException 숫자로 변환할 수 없는 문자열이 입력된 경우
     */
    protected int sumPositiveNumbers(String[] parts) {
        int result = 0;
        for (String part : parts) {
            int target = Integer.parseInt(part);
            if (target > 0) {
                result += target;
            } else {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        }
        return result;
    }
}