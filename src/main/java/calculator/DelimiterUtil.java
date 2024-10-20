package calculator;

import java.util.ArrayList;
import java.util.List;

public class DelimiterUtil {
    private static final List<String> DEFAULT_SEPARATOR = List.of(":", ",");
    private static final String DOUBLE_BACKSLASH_DELIMITER = "\\\\";
    private static final String BACKSLASH_DELIMITER = "\\";

    public static List<String> getCustomSeparators(List<String> newSeparators) {
        List<String> separators = new ArrayList<>(DEFAULT_SEPARATOR);

        newSeparators.forEach(separator ->
                addSeparator(separators, separator)
        );

        return separators;
    }

    private static void addSeparator(List<String> separators, String newSeparator) {
        if (!separators.contains(newSeparator)) {
            if (newSeparator.equals(BACKSLASH_DELIMITER)) {
                separators.add(DOUBLE_BACKSLASH_DELIMITER);
            } else {
                separators.add(newSeparator);
            }
        }
    }
}
