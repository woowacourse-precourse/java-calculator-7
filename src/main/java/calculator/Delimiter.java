package calculator;

public class Delimiter {
    private final String delimiterPattern;
    private boolean isCustomDelimiter = false;

    public Delimiter(String inputString) {
        String defaultDelimiter = ",|:";
        if (checkContainsCustom(inputString)) {
            validateCustomDelimiterForm(inputString);
            validateSingleChar(inputString);
            this.isCustomDelimiter = true;
        }
        this.delimiterPattern = defaultDelimiter;
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

}
