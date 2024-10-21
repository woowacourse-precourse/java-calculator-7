package calculator;

public class StringCalculator {
    private final DelimiterProcessor delimiterProcessor = new DelimiterProcessor();
    private final NumberParser numberParser = new NumberParser();

    public int calculate(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        // 구분자를 처리하고 숫자 부분만 추출
        String[] tokens = delimiterProcessor.process(input);

        // 숫자들을 파싱하고 합계를 계산
        int sum = 0;
        for (String token : tokens) {
            sum += numberParser.parse(token);
        }
        return sum;
    }
}