package calculator;

import java.util.Arrays;

/**
 * Calculator 클래스는 숫자 배열을 처리하여 계산 기능을 제공하는 추상 클래스입니다.
 * <p>
 * 이 클래스는 하위 클래스에서 상속받아 사용할 수 있으며, 배열에 포함된 숫자를 모두 더하는 기능을 제공합니다.
 * </p>
 *
 * @author JBumLee
 * @version 2024/10/19
 */
public abstract class Calculator {
    /**
     * 주어진 int 배열에 포함된 모든 숫자를 더합니다.
     *
     * <p>
     * 이 메소드는 내부적으로 Java Stream API를 사용하여 배열의 모든 숫자를 합산합니다.
     * </p>
     *
     * @param numbers 더할 숫자들의 배열 (int 범위)
     * @return 주어진 숫자들의 합계
     */
    protected long sum(int... numbers) {
        return Arrays.stream(numbers).sum();
    }
}