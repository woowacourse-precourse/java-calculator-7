package calculator;

public class StringCalculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 구분자 정의
        String delimiter = "[,|:]";

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 1);
        }

        // 정의된 구분자로 문자열 처리
        String[] tokens = input.split(delimiter);

        // 처리된 문자열 덧셈 계산
        return sumTokens(tokens);
    }

    // 문자열 덧셈 계산
    private int sumTokens(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            try {
                int number = Integer.parseInt(token);
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않는 값입니다:" + number);
                }
                sum += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 값입니다:" + token);
            }
        }
        return sum;
    }
}
