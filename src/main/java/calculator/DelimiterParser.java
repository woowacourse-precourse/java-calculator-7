package calculator;

public class DelimiterParser {
    public int[] extractNumbers(String input) {
        String[] stringNumbers = input.split("[,;]");
        int[] numbers = new int[stringNumbers.length];

        for (int i = 0; i < stringNumbers.length; i++) {
            try {
                numbers[i] = Integer.parseInt(stringNumbers[i]);
            } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 숫자 형식입니다: " + stringNumbers[i]);
            }
        }
        return numbers;
    }
}
