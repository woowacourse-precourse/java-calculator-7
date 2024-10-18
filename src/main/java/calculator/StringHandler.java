package calculator;

public class StringHandler {
    public String[] split(String text, String delimiter) {
        if(text.startsWith("//")) {
            int customDelimiterIndex = text.indexOf("\\n");
            if(customDelimiterIndex == -1) {
                throw new IllegalArgumentException("잘못된 구분자입니다.");
            }
            delimiter = text.substring(2, customDelimiterIndex);
            text = text.substring(customDelimiterIndex + 2);
        }

        return text.split(delimiter);
    }
}
