package calculator.controller;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
    public int calculate(List<String> separated) {
        return sum(pickNumbers(separated));
    }

    private List<Integer> pickNumbers(List<String> separated) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < separated.size(); i++) {
            if (i % 2 == 0) { // 숫자
                numbers.add(Integer.parseInt(separated.get(i)));
            }
        }
        return numbers;
    }

    private int sum(List<Integer> numbers) {
        int answer = 0;

        for (int num : numbers) {
            answer += num;
        }

        return answer;
    }
}
