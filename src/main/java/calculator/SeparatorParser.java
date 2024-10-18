package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparatorParser {
    private static final Pattern pattern = Pattern.compile("//(.*)\\\\n(.*)");
    private final Matcher matcher;

    public SeparatorParser(String input) {
        this.matcher = pattern.matcher(input);
    }

    public boolean isCustomSeparatorExist() {
        return matcher.find();
    }

    public String getCustomSeparator() {
        return matcher.group(1);
    }

    public String getMathematicalExpression() {
        return matcher.group(2);
    }
}
