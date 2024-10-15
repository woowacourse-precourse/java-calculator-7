package domain;

import util.DelimiterParser;

public class StringCalculator {
    private final DelimiterParser delimiterParser;

    public StringCalculator() {
        this.delimiterParser = new DelimiterParser(); // DelimiterParser 사용
    }

    public int add(String input) throws IllegalArgumentException{
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = delimiterParser.getDelimiter(input);
        String processedInput = delimiterParser.getNumbersString(input);

        String[] tokens = processedInput.split(delimiter);

        return sumNumbers(tokens);
    }

    private int sumNumbers(String[] tokens) throws IllegalArgumentException {
        checkValidNumber(tokens);

        int sum = 0;
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;  // 빈 문자열은 무시
            }

            sum += Integer.parseInt(token);
        }
        return sum;
    }

    public void checkValidNumber(String[] tokens) throws IllegalArgumentException{
        for(String token : tokens){
            if (token.isEmpty()) {
                continue;  // 빈 문자열은 무시
            }

            int number;

            try {
                number = Integer.parseInt(token);  // 숫자로 변환
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식" + token);  // 숫자가 아닌 값이 들어올 경우
            }

            if(number < 0){
                throw new IllegalArgumentException("잘못된 숫자 형식 " + token); // 음수가 들어 오는 경우
            }
        }
    }
}
