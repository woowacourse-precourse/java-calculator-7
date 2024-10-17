package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StringTokenizer implements Tokenizer {
    private final StringBuilder delimiters;

    public StringTokenizer(StringBuilder delimiters) {
        this.delimiters = delimiters;
        addDelimiter(",");
        addDelimiter(":");
    }

    private void addDelimiter(String delimiter) {
        if (isSpecialDelimiter(delimiter)) {
            delimiters.append("\\");
        }

        delimiters.append(delimiter);
        delimiters.append("|");
    }

    @Override
    public List<String> tokenize(String input) {
        String string = input;

        if (customDelimiterContains(string)) {
            string = addCustomDelimiter(string);
        }

        java.util.StringTokenizer st = new java.util.StringTokenizer(string, delimiters.toString());
        List<String> stringList = new ArrayList<>();

        while(st.hasMoreTokens()) {
            stringList.add(st.nextToken());
        }

        return stringList;
    }

    private String addCustomDelimiter(String input) {
        String[] split = input.split("//|\\\\n");
        addDelimiter(split[1]);

        return split[2];
    }

    private boolean customDelimiterContains(String input) {
        return input.startsWith("//");
    }

    private boolean isSpecialDelimiter(String string) {
        if (string.equals("\"") || string.equals("\'") || string.equals("\\") || string.equals("(") ||
                string.equals(")") || string.equals("[") || string.equals("]") || string.equals("}") ||
                string.equals("{") || string.equals("?") || string.equals("*") || string.equals("|")) {
            return true;
        }

        return false;
    }
}
