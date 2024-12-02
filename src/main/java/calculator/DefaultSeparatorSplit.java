package calculator;

import java.util.List;

public class DefaultSeparatorSplit implements Splitor {
    private final String str;
    private final String separator;

    DefaultSeparatorSplit(String str) {
        this.str = str;
        this.separator = Regex.DEFAULT_SEPARATOR_REGEX.getPattern();
    }

    @Override
    public List<String> split() {
        return List.of(str.split(separator));
    }
}
