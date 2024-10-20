package calculator;

import java.util.regex.Pattern;

public class InputString {
    private final String input;
    private String body;
    private String pattern;
    private String[] tokens;

    public InputString(String input) {
        this.input = input;
    }

    public void setPattern() {
        final String CUSTOM_DELIMITER_PATTERN = "//.\\\\n.*";
        pattern = ",|:";

        // 커스텀 구분자를 사용하는 경우
        if (Pattern.matches(CUSTOM_DELIMITER_PATTERN, input)) {
            // 입력받은 문자열에서 커스텀 지정자를 추출한 후, 이 또한 구분자의 역할을 하도록 regex를 수정.
            pattern = pattern + '|' + input.charAt(2);
            body = input.substring(5);
            return;
        }

        // 커스텀 구분자를 사용하지 않는 경우
        body = input;
    }

    public void setTokens() {
        if (body.isEmpty() || pattern.isEmpty()) {
            setPattern();
        }
        tokens = body.split(pattern);
    }

    public int calculate() {
        int sum = 0;
        try {
            // 문자열 배열에 저장된 각 숫자들을 int 타입으로 변환하여 누적 합 연산.
            for (String number : tokens) {
                if (Integer.parseInt(number) <= 0) {
                    throw new IllegalArgumentException();
                }
                sum += Integer.parseInt(number);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        } // NumberFormatException 발생 시 배열의 요소가 숫자 형태가 아닌 잘못된 입력이 존재하는 것이므로 예외 발생.

        return sum;
    }
}
