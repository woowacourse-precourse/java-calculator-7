package calculator;

public class Delimiter {
    private String delimiter;

    public Delimiter(String input) {
        if (input.startsWith("//") && input.contains("\n")) {
            int delimiterIndex = input.indexOf("\n");
            this.delimiter = input.substring(2, delimiterIndex);  // 커스텀 구분자
        } else {
            this.delimiter = "[,|:]";  // 기본 구분자 쉼표와 콜론
        }
    }

    public String getDelimiter() {
        return delimiter;
    }
}
