package calculator;

public class StringParser {

    private final Delimiter delimiter;

    public StringParser(Delimiter delimiter) {
        this.delimiter = delimiter;
    }

    public String[] parse(String input) {
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            input = input.substring(delimiterIndex + 1);  // 구분자 이후의 문자열로 설정
        }
        return input.split(delimiter.getDelimiter());
    }
}
