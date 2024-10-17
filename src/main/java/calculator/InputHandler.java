package calculator;

import java.util.*;

public class InputHandler {
    private String input;

    public InputHandler(String input) {
        this.input = input.replace("\\n", "\n");
    }

    private boolean isCustomSeparator() {
        return input.matches("//\\D+(\r?\n)[\\s\\S]+");
    }

    private String extractSeparator() {
        if (isCustomSeparator()) {
            StringBuilder separator = new StringBuilder();
            int idx = 2;
            while (true) {
                separator.append(input.charAt(idx++));
                if (input.charAt(idx) == '\n') break;
            }
            input = input.substring(idx + 1);
            return escapeRegex(separator.toString());
        } else {
            return "[,:]";
        }
    }

    private String escapeRegex(String separator) {
        return separator.replaceAll("([\\\\.\\[\\](){}*+?^$|])", "\\\\$1");
    }

    public List<String> extractNumber() {
        String separator = extractSeparator();
        return Arrays.asList(input.split(separator));
    }
}
