package calculator.domain;

public class Delimiter {

    // 문자열에서 커스텀 구분자를 지정했는지 확인하고 인덱스 반환
    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }

    // 커스텀 구분자의 유효성 확인
    private static void isValidCustomDelimiter(String delimiter) {
        if (delimiter.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 한 글자여야 합니다.");
        }
    }

    // 커스텀 구분자를 추출
    public static String getCustomDelimiter(String input) {
        if (hasCustomDelimiter(input)) {
            int delimiterIndex = input.indexOf("\\n");
            String delimiter = input.substring(2, delimiterIndex);

            isValidCustomDelimiter(delimiter);

            return delimiter;
        }

        // 커스텀 구분자가 없으면 null을 반환
        return null;
    }
}
