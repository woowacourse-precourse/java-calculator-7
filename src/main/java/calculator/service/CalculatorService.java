package calculator.service;

public class CalculatorService {
    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 각 자리 숫자의 합을 계산하는 부분
        return sumDigits(input);
    }

    private int sumDigits(String input) {
        int sum = 0;
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            } else {
                throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
            }
        }
        return sum;
    }
}
