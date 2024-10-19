package calculator.domain;

import java.util.List;

/**
 * 추출된 숫자들의 결과 값을 계산하는 클래스
 */
public class ResultCalculator {
    /**
     * 추출된 숫자 List의 합을 반환
     * @param numbers 추출된 숫자 List
     * @return List 내부 숫자들의 합
     */
    public long getSum(List<Integer> numbers) {
        long sum = 0; // 숫자 합

        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }
}
