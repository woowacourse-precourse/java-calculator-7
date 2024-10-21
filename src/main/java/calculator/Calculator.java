package calculator;

import java.util.List;

public class Calculator {


    // 입력 문자열의 숫자 합을 계산
    public int calculate(String input) {
        Parser parser = new Parser();
        List<Integer> numbers = parser.parse(input);
        return sum(numbers);
    }

    // 숫자 리스트의 합을 계산
    private int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
