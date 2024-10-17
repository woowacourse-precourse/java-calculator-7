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

    public Separator(List<String> separator) {
        List<String> separators = Arrays.asList(",", ";");
        separators.addAll(separator);
        this.separator = separators;
    }

    public String getRegex() {
        return String.join("|", separator);
    }
}
