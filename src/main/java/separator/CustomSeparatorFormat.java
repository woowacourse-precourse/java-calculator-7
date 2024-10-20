package separator;

import java.util.regex.Pattern;

public class CustomSeparatorFormat {
    private final Pattern pattern;
    public CustomSeparatorFormat() {
        this.pattern = Pattern.compile("//+(.*)\\\\n+(.*)");
    }

    public CustomSeparatorFormat(Pattern pattern) {
        this.pattern = pattern;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
