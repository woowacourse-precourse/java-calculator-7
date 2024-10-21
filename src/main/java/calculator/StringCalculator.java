package calculator;

public class StringCalculator {
    private final StringParser parser = new StringParser();
    private final StringValidator validator = new StringValidator();
    private static final int MAX_INPUT_LENGTH = 1000;

    public int add(String input) {
        // 빈 입력 처리
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        // 입력 길이 제한 검사
        if (input.length() > MAX_INPUT_LENGTH) {
            throw new IllegalArgumentException("입력 문자열의 최대 허용 길이는 " + MAX_INPUT_LENGTH + "자입니다.");
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
