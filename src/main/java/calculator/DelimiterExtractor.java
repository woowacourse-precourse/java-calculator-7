package calculator;

import java.util.ArrayList;
import java.util.List;

public class DelimiterExtractor {

    List<String> delimiters = new ArrayList<>();

    public List<String> extract(String input) {
        if (input.startsWith("//")) {
            String customDelimiter = extractCustomDelimiter(input);
            delimiters.add(customDelimiter);
        }

        extractBasicDelimiter(input);

        return delimiters;
    }

    private String extractCustomDelimiter(String input) {
        return input.substring(2, input.indexOf("\\n"));
    }

    private void extractBasicDelimiter(String input) {
        Delimiter.getBasicDelimiters().forEach(delimiter -> {
            if (input.contains(delimiter)) {
                delimiters.add(delimiter);
            }
        });
    }

}
