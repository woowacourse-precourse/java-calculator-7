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
        return input.split("[,;]");
    }

}
