package calculator;

public class StringCalculator {
    public int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        String[] numbers = input.split("[,:]");
        int sum = 0;

        for (String number : numbers) {
            String trimmedNumber = number.trim();
            if (trimmedNumber.isEmpty() || Integer.parseInt(trimmedNumber) < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            sum += Integer.parseInt(trimmedNumber);
        }
        return sum;
    }
}
