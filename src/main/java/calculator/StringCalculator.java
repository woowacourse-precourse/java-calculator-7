package calculator;

public class StringCalculator {
    private final StringParser parser = new StringParser();
    private final StringValidator validator = new StringValidator();


    public int add(String input) {
        // 빈 입력 처리
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 문자열 파싱
        String[] tokens = parser.parse(input);

        //유효성 검사
        validator.validate(tokens);

        // 덧셈 결과 반환
        return sumTokens(tokens);
    }

    // 문자열 덧셈 계산
    private int sumTokens(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}
