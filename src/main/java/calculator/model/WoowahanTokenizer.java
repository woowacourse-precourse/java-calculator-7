package calculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WoowahanTokenizer {
    private String inputString;
    private final String defaultSeparator = ",:";
    private String customSeparator;

    public WoowahanTokenizer(String inputString) {
        this.inputString = inputString;
        this.customSeparator = "";
    }

    public void setCustomSeparator() {
        if (inputString.length() <= 4) return;
        if (inputString.charAt(0) != '\\') return;
        if (inputString.charAt(1) != '\\') return;
        if (inputString.charAt(3) != '\\') return;
        if (inputString.charAt(4) != 'n') return;
        customSeparator = inputString.substring(2, 3);
        inputString = inputString.substring(5);
    }
    public List<String> tokenizeString() {
        String separator = defaultSeparator + customSeparator;
        StringTokenizer st = new StringTokenizer(inputString, separator);
        List<String> result = new ArrayList<>();
        while (st.hasMoreTokens()) {
            result.add(st.nextToken());
        }
        return result;
    }

    public String getCustomSeparator() {
        return customSeparator;
    }
    public String getInputString() {
        return inputString;
    }

}
