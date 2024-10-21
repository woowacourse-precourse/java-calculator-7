package calculator;
import java.util.List;

public class CalculatorLogic {
    public static int calculateSum(List<String> numbers) {
        ExceptionLogic.validateInput(numbers);

        int sum = 0;
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                int num = Integer.parseInt(number.trim());
                sum += num;
            }
        }
        return sum;
    }
}