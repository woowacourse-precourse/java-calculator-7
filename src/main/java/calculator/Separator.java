package calculator;

import java.util.Arrays;
import java.util.List;

public class Separator {

    private final List<String> separator;

    public Separator() {
        this.separator = Arrays.asList(",", ":");
    }

    public List<String> getSeparator() {
        return separator;
    }

    public Separator(String customSeparator) {
        List<String> separators = Arrays.asList(",", ";");
        separators.add(customSeparator);
        this.separator = separators;
    }

    public String getRegex() {
        return String.join("|", separator);
    }
}
