package calculator.service;

import java.util.List;
// 숫자들의 합을 구해 반환하기 위한 클래스
public class Calculator {

    // 숫자들의 합을 구해 반환하는 메소드
    public static Integer calculateSum(List<Integer> numbers) {
        Integer sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
