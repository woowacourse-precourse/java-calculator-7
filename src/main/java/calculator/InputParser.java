package calculator;

import java.util.regex.Pattern;

public class InputParser {
    public int[] parse(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력 값이 null 일 수 없습니다.");
        }

        input = input.trim();

        if (input.isEmpty()) {
            return new int[]{0};  // 빈 문자열일 경우 0 반환
        }

        input = input.replaceAll("\\s+", "");

        String delimiter = "[,|:]"; // 기본 구분자
        boolean customDelimiterUsed = false;

        if (input.startsWith("//")) {
            int delimiterEnd = input.indexOf("\\n");
            if (delimiterEnd != -1) {
                String customDelimiter = input.substring(2, delimiterEnd);
                if (customDelimiter.isEmpty()) {
                    throw new IllegalArgumentException("커스텀 구분자는 빈 문자열일 수 없습니다.");
                }
                delimiter = Pattern.quote(customDelimiter) + "|[,|:]";
                input = input.substring(delimiterEnd + 2);
                customDelimiterUsed = true;  // 커스텀 구분자 사용 여부를 기록
            } else {
                throw new IllegalArgumentException("잘못된 입력형식입니다: " + input);
            }
        }

        if (!customDelimiterUsed && input.matches(".*[,|:]{2,}.*")) {
            throw new IllegalArgumentException("잘못된 구분자가 연속으로 사용되었습니다.");
        }

        String[] tokens = input.split(delimiter);

        for (String token : tokens) {
            if (!token.matches("-?\\d+")) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + token);
            }
            if (token.equals("0")) {
                throw new IllegalArgumentException("0은 입력할 수 없습니다.");
            }
        }

        int[] numbers = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);  // 각각의 토큰을 int 로 변환
        }

        return numbers;
    }
}
