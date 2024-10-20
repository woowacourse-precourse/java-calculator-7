package calculator;

import java.util.List;

/**
 * 숫자 리스트의 합을 계산하는 클래스입니다.
 */
public class Calculator {

    /**
     * 주어진 숫자 리스트의 합을 반환합니다.
     *
     * @param numbers 합을 계산할 숫자 리스트
     * @return 숫자들의 합, 리스트가 비어있으면 0을 반환
     */
    public int add(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
