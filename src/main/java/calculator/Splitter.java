package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Splitter {

    public List<Operand> split(String text) {
        String delimiters = extractDelimiters(text);
        String expression = removeCustomDelimiter(text);

        return Arrays.stream(expression.split("[" + delimiters + "]"))
                .map(Operand::new)
                .toList();
    }

    private String removeCustomDelimiter(String text) {
        if (containedCustomDelimiter(text)) {
            return text.substring(text.indexOf("\\n") + 2);
        }

        return text;
    }

    private String extractDelimiters(String text) {
        List<String> delimiters = new ArrayList<>(List.of(",", ":"));
        addCustomDelimiter(text, delimiters);

        return String.join("", delimiters);
    }

    private void addCustomDelimiter(String text, List<String> delimiters) {
        if (containedCustomDelimiter(text)) {
            String customDelimiter = text.substring(2, text.indexOf("\\n"));
            delimiters.add(customDelimiter);
        }
    }

    private boolean containedCustomDelimiter(String text) {
        return text.startsWith("//") && text.contains("\\n");
    }
}
