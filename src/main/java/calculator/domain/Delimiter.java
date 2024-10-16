package calculator.domain;

public class Delimiter {

    // 커스텀 구분자가 있는지 확인하는 메서드
    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//") && input.contains("\n");
    }

    // 커스텀 구분자를 추출하고 유효성 확인
    public static String getCustomDelimiter(String input) {
        if (hasCustomDelimiter(input)) {
            int delimiterIndex = input.indexOf("\n");
            String delimiter = input.substring(2, delimiterIndex);

            // 커스텀 구분자는 1개까지만 인정
            if (delimiter.length() != 1) {
                throw new IllegalArgumentException("커스텀 구분자는 한 글자여야 합니다.");
            }

            return delimiter;
        }

        // 커스텀 구분자가 없으면 null을 반환
        return null;
    }
}
