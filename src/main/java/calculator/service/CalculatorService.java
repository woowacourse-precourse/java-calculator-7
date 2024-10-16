package calculator.service;

public class CalculatorService {

    public void calculate(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }
}
