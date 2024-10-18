package calculator;

import java.util.HashSet;
import java.util.Set;

public class Delimiter {
    private String input;
    private Set<String> delimiters = new HashSet<>();

    public Delimiter(String input) {
        this.input = input;
        this.delimiters = extractingDelimiters();
    }

    private Set<String> extractingDelimiters() {
        extractingCustomDelimiters();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                sb.append(c);
            }

            if (!sb.isEmpty() && Character.isDigit(c)){
                delimiters.add(sb.toString());
                sb.setLength(0);
            }
        }
        return delimiters;
    }

    private void extractingCustomDelimiters() {
        if (input.startsWith("//") && input.contains("\\n")) {
            int start = input.indexOf("//") + 2;
            int end = input.indexOf("\\n");
            String customerDelimiter = input.substring(start, end);
            delimiters.add(customerDelimiter);
            input = input.replace("//" + customerDelimiter + "\\n", "");
        }
    }

    public Set<String> getDelimiters() {
        return delimiters;
    }
}
