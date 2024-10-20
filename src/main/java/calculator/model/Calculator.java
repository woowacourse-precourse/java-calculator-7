package calculator.model;

import java.util.List;

public class Calculator {

    private final List<Integer> numbers;

    public Calculator(List<Integer> numbers){
        this.numbers = numbers;
    }

    /* 유효성 검사 로직 추가도 가능
     * 예를 들어 list 내에 음수, 문자가 있는지 등
     * 현재는 service 로직에 추가
     */


    // 도메인 로직 처리, 비즈니스 규칙 처리
    public int getSum() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
