package calculator.domain;

public class Calculator {

    public int calculateSum(String[] numberStrings) {
        int sum = 0;
        for (String numberString : numberStrings) {
            int number = validateNumericContent(numberString);
            validateNoNegativeNumber(number);
            sum += Integer.parseInt(numberString);
        }
        return sum;
    }

    private void validateNoNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("입력값 중 숫자는 0보다 커야합니다.");
        }
    }

    private int validateNumericContent(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("분리된 입력값에 문자열이 존재합니다.");
        }
    }
}
