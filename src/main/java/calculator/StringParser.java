package calculator;

import java.util.regex.Pattern;

public class StringParser {

    // 사용자 입력 문자열
    private final String input;

    // 구분자 (기본 구분자 + 커스텀 구분자)
    private String delimiter;

    // input 내 숫자 & 구분자 (뒷부분)
    private String numbers;

    public StringParser(String input) {

        this.input = input;
        this.delimiter = ",|:";

        parseInput();
    }

    private void parseInput() {

        // 빈 문자열 처리
        if (input == null || input.isEmpty()) {
            return;
        }

        // 커스텀 구분자 감지 및 처리
        if (input.startsWith("//")) {

            // "\\n"을 실제 줄바꿈 문자로 변환
            String modifiedInput = input.replace("\\n", "\n");

            int delimiterEndIndex = modifiedInput.indexOf("\n");

            if (delimiterEndIndex > 2) {

                // 커스텀 구분자 추출
                String customDelimiter = modifiedInput.substring(2, delimiterEndIndex);

                // 커스텀 구분자와 기본 구분자 결합
                this.delimiter = Pattern.quote(customDelimiter) + "|,|:";

                this.numbers = modifiedInput.substring(delimiterEndIndex + 1);

            }
            // 커스텀 구분자 형식이 잘못된 경우
            else {
                throw new IllegalArgumentException("잘못된 형식의 커스텀 구분자 입력입니다.");
            }
        }
        // 기본 구분자 사용
        else {
            this.numbers = input;
        }
    }

    public String[] getTokens() {
        // 빈 문자열
        if (numbers.isEmpty()) {
            return new String[]{};
        }
        return numbers.split(delimiter);
    }
}
