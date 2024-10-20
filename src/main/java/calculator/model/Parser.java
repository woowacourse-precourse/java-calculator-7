package calculator.model;

public class Parser {

    public int[] parseNumbersFromExpression(String expression, String delimiter) {
        String[] tokens = expression.split(delimiter);
        int[] result = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i].trim();
            try {
                int num = Integer.parseInt(token);
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
                }
                result[i] = num;
            } catch (NumberFormatException e) {
                if (token.matches("-?\\d+")) {
                    throw new IllegalArgumentException("입력 값이 정수의 범위를 초과합니다: " + token);
                } else {
                    throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + token);
                }
            }
        }

        return result;
    }
}