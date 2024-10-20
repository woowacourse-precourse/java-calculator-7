package calculator;

import java.util.Arrays;

public class Calculator { //TODO: 입력된 숫자들을 모두 더해서 반환
    public static Integer calculate(String expression) {
        if (InputHandler.isNullOrEmpty(expression)) {
            return 0;
        }
        int total = 0;
        String[] numbers = StringSeparator.separator(expression);
        total = getAdditionResult(numbers, total);
        return total;
    }

    private static int getAdditionResult(String[] numbers, int total) {
        for (String num : numbers) {
            total += Integer.parseInt(num);
        }
        return total;
    }
}
