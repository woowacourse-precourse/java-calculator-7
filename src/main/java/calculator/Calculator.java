package calculator;

import java.util.List;

// 추출한 숫자를 더해주는 Calculator 클래스
public class Calculator {
    public int sumNumbers(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
