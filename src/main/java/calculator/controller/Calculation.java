package calculator.controller;

import java.util.List;

public class Calculation {
    public int calculate(List<String> separated) {
        return sum(pickNumbers(separated));
    }

    private int[] pickNumbers(List<String> separated) {
        int[] numbers = new int[separated.size() / 2 + 1];
        for (int i = 0; i < separated.size(); i++) {
            if (i % 2 == 0) { // 숫자
                numbers[i / 2] = Integer.parseInt(separated.get(i));
            }
        }
        return numbers;
    }

    private int sum(int[] numbers) {
        int answer = 0;

        for (int num : numbers) {
            answer += num;
        }

        return answer;
    }
}
