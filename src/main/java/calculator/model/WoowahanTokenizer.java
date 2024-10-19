package calculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WoowahanTokenizer {
    private String inputString;
    private final String defaultSeparator = ",:";
    private String customSeparator;
    private List<String> stringTokens;

    public WoowahanTokenizer(String inputString) {
        this.inputString = inputString;
        this.customSeparator = "";

        setCustomSeparator();
        tokenizeString();
    }

    private void setCustomSeparator() {
        if (inputString.length() < 4) return;
        if (inputString.charAt(0) != '/') return;
        if (inputString.charAt(1) != '/') return;
        if (inputString.charAt(3) != '\n') return;
        customSeparator = inputString.substring(2, 3);
        inputString = inputString.substring(4);
    }

    private void tokenizeString() {
        String separator = defaultSeparator + customSeparator;
        StringTokenizer st = new StringTokenizer(inputString, separator);
        List<String> result = new ArrayList<>();
        while (st.hasMoreTokens()) {
            result.add(st.nextToken());
        }
        stringTokens = result;
    }

    public String getCustomSeparator() {
        return customSeparator;
    }
    public String getInputString() {
        return inputString;
    }
    public List<String> getStringTokens() {
        return stringTokens;
    }

}
