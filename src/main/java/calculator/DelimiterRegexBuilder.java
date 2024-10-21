package calculator;

public class DelimiterRegexBuilder {

    private final String delimiter;

    public DelimiterRegexBuilder(String delimiter) {
        this.delimiter = delimiter;
    }
    public String buildRegexPattern() {
        StringBuilder pattern = new StringBuilder("[");

        for (char c : this.delimiter.toCharArray()) {
            pattern.append("|").append(c);
        }

        pattern.deleteCharAt(1).append("]");
        return pattern.toString();
    }
}
