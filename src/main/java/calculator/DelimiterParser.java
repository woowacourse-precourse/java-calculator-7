package calculator;

public class DelimiterParser {
    public static String[] split(String input) {
        // 기본 구분자: 쉼표와 콜론
        String[] delimiters = {",", ":"};

        // 커스텀 구분자 확인
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");  // "\\n" 문자열을 찾음
            if (delimiterEndIndex == -1) {  // "\\n"이 없는 경우
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }
            // 커스텀 구분자 추출
            String customDelimiter = input.substring(2, delimiterEndIndex);
            // 구분자 제거 후 나머지 문자열 추출
            input = input.substring(delimiterEndIndex + 2);  // "\\n" 이후의 문자열

            // 커스텀 구분자로 분리
            return splitByCustomDelimiter(input, customDelimiter);
        }

        // 기본 구분자 처리
        return splitByDefaultDelimiters(input, delimiters);
    }

    // 커스텀 구분자
    private static String[] splitByCustomDelimiter(String input, String delimiter) {
        return input.split(delimiter);
    }

    // 기본 구분자
    private static String[] splitByDefaultDelimiters(String input, String[] delimiters) {
        for (String delimiter : delimiters) {
            input = input.replace(delimiter, " ");
        }
        return input.split(" ");
    }
}
