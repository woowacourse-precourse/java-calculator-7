package calculator;

public class Calculator {

    public int calculate(String input) {
        String delimiter = ",|:";
        String numbers = input;

        // 커스텀 구분자가 있는지 확인
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");

            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("유효하지 않은 커스텀 구분자 형식입니다.");
            }

            delimiter = input.substring(2, delimiterIndex);
            numbers = input.substring(delimiterIndex + 2);
        }

        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        String[] tokens = numbers.split(delimiter);
        int sum = 0;

        for (String token : tokens) {
            token = token.trim();
            int number = Integer.parseInt(token);
            sum += number;
        }

        return sum;
    }
}
