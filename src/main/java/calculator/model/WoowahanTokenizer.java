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
        validateString();
        tokenizeString();
    }

    private void setCustomSeparator() {
        if (inputString.length() < 5) return;
        if (inputString.charAt(0) != '/') return;
        if (inputString.charAt(1) != '/') return;
        if (inputString.charAt(3) != '\\') return;
        if (inputString.charAt(4) != 'n') return;
        customSeparator = inputString.substring(2, 3);
        inputString = inputString.substring(5);
    }
    private void validateString() {
        // validate no consecutive separator
        // 커스텀 구분자가 - 일 때, 연속한 커스텀 구분자가 없는지 검증
        if (!customSeparator.equals("-")) return;
        for (int i = 0; i < inputString.length() - 1; i++) {
            if (inputString.charAt(i) == '-' && inputString.charAt(i + 1) == '-') {
                throw new IllegalArgumentException();
            }
        }
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
