package calculator;

public class InputParser {
    public int[] parse(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력 값이 null 일 수 없습니다.");
        }

        if (input.isEmpty()) {
            return new int[]{0};  // 빈 문자열일 경우 0 반환
        }

        input = input.trim();

        if (input.contains(" ")) {
            input = input.replaceAll("\\s+", "");
        }

        String delimiter = "[,|:]"; // 기본 구분자
        if (input.startsWith("//")) {
            int delimiterEnd = input.indexOf("\\n");
            if (delimiterEnd != -1) {
                String customDelimiter = input.substring(2, delimiterEnd);
                if (customDelimiter.isEmpty()) {
                    throw new IllegalArgumentException("커스텀 구분자 안에 빈 문자열일 수 없습니다.");
                }
                delimiter = customDelimiter;
                input = input.substring(delimiterEnd + 2);
            } else {
                throw new IllegalArgumentException("잘못된 입력형식입니다: " + input);
            }
        }

        String[] tokens = input.split(delimiter);
        int[] numbers = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);  // 각각의 토큰을 int 로 변환
        }

        return numbers;
    }
}
