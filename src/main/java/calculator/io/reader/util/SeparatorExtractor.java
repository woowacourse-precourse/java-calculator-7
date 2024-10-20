package calculator.io.reader.util;

import java.util.List;

public class SeparatorExtractor {
    public List<String> extractSeparator(String input) {
        if (input.startsWith("//"))
            return List.of(",", ":", input.substring(2, 3));
        else
            return List.of(",", ":");
    }
}
