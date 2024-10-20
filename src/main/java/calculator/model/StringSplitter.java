package calculator.model;

public class StringSplitter {
    private static final String DEFAULT_DELIMITERS = "[,:]";

    public String[] split(String input) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            // 첫 번째 줄과 그 이후로 분리
            String[] parts = input.split("\n", 2);
            if (parts.length != 2) {
                throw new IllegalArgumentException("유효하지 않은 입력 형식입니다.");
            }
            // 커스텀 구분자 분리
            String customDelimiter = parts[0].substring(2);
            return parts[1].split(customDelimiter);
        }

        // 기본 구분자 쉼표(,)와 콜론(:)으로 분리
        return input.split(DEFAULT_DELIMITERS);
    }
}