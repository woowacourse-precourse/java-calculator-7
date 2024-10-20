package calculator;

public class StringCalculator {

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        if (input.matches("\\d+")) {  // 숫자 하나일 경우
            return Integer.parseInt(input);
        }
        return -1;
    }
}
