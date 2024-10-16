package calculator.domain;

public class Calculator {

    public int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }
        return -1; // 임시 리턴값
    }
}
