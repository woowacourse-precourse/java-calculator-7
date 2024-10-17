package calculator.domain;

import java.util.List;

public class Number {
    private List<Integer> numbers;

    // Number 생성자의 파라미터로 숫자 리스트를 입력잡아서 초기화
    public Number(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // 외부에 숫자들을 반환하는 getter 메서드
    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
