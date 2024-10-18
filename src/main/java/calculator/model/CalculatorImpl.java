package calculator.model;

public class CalculatorImpl implements Calculator {

    private final ExtractNumber extractNumber;

    public CalculatorImpl(ExtractNumber extractNumber) {
        this.extractNumber = extractNumber;
    }

    @Override
    public int calculate(String input) {

        if (isEmptyInput(input)) {
            return 0;
        }
        String[] numbers = extractNumber.extractNumberFromInput(input);
        return sum(numbers);
    }

    private int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            checkNegativeNumber(num);
            total += num;
        }
        return total;
    }

    private boolean isEmptyInput(String input) {
        return input == null || input.trim().isEmpty();
    }

    public void checkNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }
    }
}
