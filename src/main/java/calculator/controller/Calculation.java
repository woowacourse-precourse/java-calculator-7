package calculator.controller;

import java.util.List;

public class Calculation {
    public int calculate(List<String> separated) {
        // 숫자만 배열에 담아 반환
        int[] numbers = pickNumbers(separated);

        // 더한 값 반환
        int answer = sum(numbers);

        return answer;
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
