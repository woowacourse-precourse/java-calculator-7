package calculator.controller;

import java.util.List;

public class Validation {
    public int validatingSeparator(List<String> separators, List<String> separated) {
        int[] numbers = new int[separated.size() / 2 + 1];
        for (int i = 0; i < separated.size(); i++) {
            if (i % 2 == 0) { // 숫자
                numbers[i / 2] = Integer.parseInt(separated.get(i));
            } else { // 문자
                if (!separators.contains(separated.get(i))) {
                    throw new IllegalArgumentException();
                }
            }
        }

        int answer = sum(numbers);
        return answer;
    }

    private int sum(int[] numbers) {
        int answer = 0;

        for (int num : numbers) {
            answer += num;
        }

        return answer;
    }
}
