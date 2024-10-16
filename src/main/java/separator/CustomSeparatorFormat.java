package separator;

import java.util.regex.Pattern;

public class CustomSeparatorFormat {
    private Pattern pattern = Pattern.compile("//+(.*)\\\\n+(.*)");
    public CustomSeparatorFormat() {
    }

    public CustomSeparatorFormat(Pattern pattern) {
        this.pattern = pattern;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
