package calculator;

public class PositiveNumberValidator {
    public int[] validateNumber(String[] tokens) {
        // 빈 문자열 or 숫자가 없는 경우 예외 처리
        if (tokens == null || tokens.length == 1 && tokens[0].isEmpty()) {
            return new int[]{0};
        }

        int[] validatedNumbers = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            try {
                int number = Integer.parseInt(tokens[i]);
                if (number > 0) {
                    validatedNumbers[i] = number;
                } else {
                    throw new IllegalArgumentException("The number must be positive: " + tokens[i]);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid number format: " + tokens[i], e);
            }
        }
        return validatedNumbers;
    }
}
