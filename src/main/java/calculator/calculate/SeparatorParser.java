package calculator.calculate;

import java.util.ArrayList;
import java.util.List;

public class SeparatorParser {

    private List<String> regex;

    public SeparatorParser() {
        this.regex = new ArrayList<>();
    }

    public List<String> findSeparator(String input) {
        if (input.contains(",")) {
            regex.add(",");
        }

        if (input.contains(":")) {
            regex.add(":");
        }

        if (input.contains("//") && input.contains("\\n")) {
            findCustomSeparator(input);
        }

        if (regex.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return regex;
    }

    private void findCustomSeparator(String input) {
        int startIndex = input.indexOf("//") + 2;
        int endIndex = input.indexOf("\\n");

        if (startIndex == -1 || endIndex == -1 || startIndex >= endIndex) {
            throw new IllegalArgumentException();
        }

        regex.add(input.substring(startIndex, endIndex));
    }

    public String removeSuffix(String input) {
        int index = input.indexOf("\\n") + 2;

        return input.substring(index);
    }
}
