package calculator;

import java.util.Arrays;

/**
 * class: Calculator.
 *
 * @author JBumLee
 * @version 2024/10/19
 */
public abstract class Calculator {
    /**
     * 배열에 들어오는 숫자를 모두 더하는 add 메소드. 내부적으로는 Stream을 사용한다.
     *
     * @param numbers int범위의 숫자
     * @return 숫자
     */
    public long add(int... numbers) {
        return Arrays.stream(numbers).sum();
    }
}
