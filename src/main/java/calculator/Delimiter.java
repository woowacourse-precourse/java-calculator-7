package calculator;

public class Delimiter {
    private final String delimiter;

    public Delimiter(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterEndIndex);
        } else {
            delimiter = ",|:";  // 기본 구분자
        }
    }

    public String getDelimiter() {
        return delimiter;
    }
}