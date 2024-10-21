package calculator;
import java.util.List;

public class CalculatorLogic {
    public static int calculateSum(List<String> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열은 허용되지 않습니다.");
        }

        int sum = 0;
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                int num = Integer.parseInt(number.trim());
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                }
                sum += num;
            }
        }
        return sum;
    }
}