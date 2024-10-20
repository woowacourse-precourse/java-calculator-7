package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final ArrayList<Integer> operands;

    public Calculator() {
        operands = new ArrayList<>();
    }

    public void parseAndAddNumbers(String input) {
        if (input == null || input.isBlank()) {
            return;
        }

        List<Integer> numbers = new ArrayList<>();
        // TODO: 문자열에서 숫자를 파싱해 numbers에 추가하는 로직 구현
        operands.addAll(numbers);
    }

    public int sum() {
        int result = 0;
        for (int num : operands) {
            result += num;
        }
        return result;
    }
}
