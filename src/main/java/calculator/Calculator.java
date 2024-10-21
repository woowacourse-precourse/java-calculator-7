package calculator;

public class Calculator {
    public int add(String input) {
        String[] numbers = DelimiterExtractor.extractNumbers(input);
        return calculateSum(numbers);
    }

    private int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (!number.isEmpty()) {
                int num = Integer.parseInt(number);
                validateNumber(num);
                sum += num;
            }
        }
        return sum;
    }

    private void validateNumber(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다. " + num);
        }
    }
}
