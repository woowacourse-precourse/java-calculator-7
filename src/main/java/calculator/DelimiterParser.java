package calculator;

public class DelimiterParser {
    private final String input;

    public DelimiterParser(String input) {
        this.input = input;
    }

    public String[] splitString() {
        if (input.startsWith("//")) {
            String[] splitList = input.split("\\\\n");
            String delimiter = splitList[0].substring(2);
            return splitList[1].split(delimiter);
        }
        if (!input.contains(",") && !input.contains(";")) {
            throw new IllegalArgumentException("',' 혹은 ';' 구분자가 포함되지 않았습니다.");
        }
        return input.split("[,;]");
    }

}
