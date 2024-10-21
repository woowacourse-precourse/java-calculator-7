package calculator;

public class NumberParser {
    // 입력 문자열을 구분자로 분리하여 숫자로 변환하는 메서드
    public static int[] parse(String input, String delimiter) {
        if (input.trim().isEmpty()) {
            return new int[0];
        }

        String[] tokens = input.split(delimiter);
        int[] numbers = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i].trim();
            if (token.isEmpty()) {
                continue; // 빈 토큰은 건너뜀
            }

            // 예외 처리는 toPositiveInteger에서만 수행
            numbers[i] = toPositiveInteger(token);
        }

        return numbers;
    }

    private static int toPositiveInteger(String token) {
        try {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException("negative number is not allowed: " + number);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number: " + token, e);
        }
    }
}
