package calculator;

public class StringSumCalculator {

    public int sumStringNumbers(String[] stringNumbers) {
        int sum = 0;
        for (String stringNumber : stringNumbers) {
            int number = Integer.parseInt(stringNumber);
            validatePositiveNumber(number);
            sum += number;
        }
        return sum;
    }

    private void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("양수가 아닌 값이 있습니다.");
        }
    }
}
