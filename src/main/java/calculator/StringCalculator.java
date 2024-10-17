package calculator;

public class StringCalculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 구분자 처리해 숫자 나누기
        String delimiter = "[,;]";
        String[] tokens = input.split(delimiter);

        return 0;
    }
}
