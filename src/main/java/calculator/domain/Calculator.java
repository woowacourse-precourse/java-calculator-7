package calculator.domain;


public class Calculator {

    public int sum(String[] operands) {
        int sum = 0;

        for (String operand : operands) {
            int number = Integer.parseInt(operand);

            if (number <= 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            sum += number;
        }

        return sum;
    }
}
