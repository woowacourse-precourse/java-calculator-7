package calculator;

public class DelimiterParser {
    // 구분자 추출
    public static String getDelimiter(String input) {
        if (input.startsWith("//") && input.contains("\n")) {
            int delimiterStart = input.indexOf("//") + 2;
            int delimiterEnd = input.indexOf("\n");
            return input.substring(delimiterStart, delimiterEnd);
        }

        return null;
    }

    // 나머지 문자열 반환
    public static String getRamainString(String input) {
        if (input.startsWith("//") && input.contains("\n")) {
            int remainStart = input.indexOf("\n") + 1;
            return input.substring(remainStart);
        }

        return input;
    }

}
