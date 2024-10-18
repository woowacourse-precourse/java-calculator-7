package calculator.service;

public class CalculatorService {

    public static int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(input);
    }
}
