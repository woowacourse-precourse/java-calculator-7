package calculator.delimiterStrategy;

import java.util.List;

public class CustomDelimiterStrategy implements DelimiterStrategy {
    public static final String startDelimiterPattern = "//";
    public static final String endDelimiterPattern = "\n";

    @Override
    public List<String> decideDelimiter(String userInput) {
        return null;
    }
}
