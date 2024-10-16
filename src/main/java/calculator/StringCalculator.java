package calculator;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String[] tokens = numbers.split("[,;]");
        int sum = 0;

        for (String token : tokens) {
            String trimmedToken = token.trim();

            if (!isNumeric(trimmedToken) || Integer.parseInt(trimmedToken) < 0) {
                throw new IllegalArgumentException();
            }

            int number = Integer.parseInt(trimmedToken);
            sum += number;
        }

        return sum;
    }

    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
