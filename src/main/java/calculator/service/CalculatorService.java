package calculator.service;

public class CalculatorService {
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] numbers = splitString(input);
        return calculateSum(numbers);
    }
    private String[] splitString(String input) {
        return input.split(",|:");
    }
}
