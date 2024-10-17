package calculator.model;

public class CalculatorImpl implements Calculator {

    private final ExtractNumber extractNumber;

    public CalculatorImpl(ExtractNumber extractNumber) {
        this.extractNumber = extractNumber;
    }

    @Override
    public int calculate(String input) {
        checkEmptyInput(input);
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

    private void checkEmptyInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다. 빈 문자열 또는 null 입력은 허용되지 않습니다.");
        }
    }

    public void checkNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }
    }
}
