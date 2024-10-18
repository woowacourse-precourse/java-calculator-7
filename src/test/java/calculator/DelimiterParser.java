package calculator;

public class DelimiterParser {
    private final DelimiterManager delimiterManager;

    public DelimiterParser(DelimiterManager delimiterManager) {
        this.delimiterManager = delimiterManager;
    }

    private String buildDelimiterRegex() {
        StringBuilder regexBuilder = new StringBuilder();

        for (String delimiter : DelimiterManager.defaultDelimiters) {
            if (regexBuilder.length() > 0) {
                regexBuilder.append("|");
            }
            regexBuilder.append(delimiter);
        }

        for (String delimiter : DelimiterManager.customDelimiters) {
            regexBuilder.append("|").append(delimiter);
        }

        return regexBuilder.toString();
    }
}
