package calculator;

import java.util.regex.Pattern;

public class Delimiter {
    private final String delimiterPattern;
    private boolean isCustomDelimiter = false;

    public Delimiter(String inputString) {
        String defaultDelimiter = ",|:";
        if (checkContainsCustom(inputString)) {
            validateCustomDelimiterForm(inputString);
            validateSingleChar(inputString);
            this.isCustomDelimiter = true;
            defaultDelimiter = addCustomPattern(defaultDelimiter, inputString);
        }
        this.delimiterPattern = defaultDelimiter;
    }

    public boolean hasCustomDelimiter() {
        return this.isCustomDelimiter;
    }

    public String getDelimiterPattern() {
        return this.delimiterPattern;
    }

    public String removeCustomDelimiterForm(String inputString) {
        int delimiterEndIndex = inputString.indexOf("\\n");

        if (delimiterEndIndex + 2 < inputString.length()) {
            return inputString.substring(delimiterEndIndex + 2);
        }

        return "0";
    }

    private boolean checkContainsCustom(String inputString) {
        return inputString.contains("//") || inputString.contains("\\n");
    }

    private void validateCustomDelimiterForm(String inputString) {
        if (inputString.startsWith("//")) {
            int delimiterEndIndex = inputString.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("[ERROR] 커스텀 구분자 지정 형식이 올바르지 않습니다.");
            }
        }

        if (!inputString.startsWith("//") && inputString.contains("\\n")) {
            throw new IllegalArgumentException("[ERROR] 커스텀 구분자 지정 형식이 올바르지 않습니다.");
        }
    }

    private void validateSingleChar(String inputString) {
        int delimiterEndIndex = inputString.indexOf("\\n");
        if (delimiterEndIndex != 3) {
            throw new IllegalArgumentException("[ERROR] 커스텀 구분자는 하나의 문자 입니다.");
        }
    }
    private String addCustomPattern(String defaultDelimiter, String inputString) {
        char customPattern = inputString.charAt(2);
        String customDelimiter = Pattern.quote(String.valueOf(customPattern));
        return defaultDelimiter + "|" + customDelimiter;
    }

}
