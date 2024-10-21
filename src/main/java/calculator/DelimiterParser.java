package calculator;

public class DelimiterParser {

    public static String[] customDelimiterParse(String input) {
        int newIndex = input.indexOf("\\n");
        if (newIndex == -1) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
        }
        String customDelimiter = input.substring(2, newIndex);
        String numbers = input.substring(newIndex + 2);
        return new String[]{customDelimiter, numbers};
    }

    public static String delimiterPattern(String delimiter) {
        if(delimiter.equals(",|;")) {
            return "[,;]";
        }
        return delimiter;
    }
}
