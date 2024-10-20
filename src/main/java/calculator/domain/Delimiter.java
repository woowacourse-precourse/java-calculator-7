package calculator.domain;

import calculator.domain.constant.DefaultDelimiter;
import java.util.ArrayList;
import java.util.List;

public class Delimiter {
    private String inputString;
    private List<String> delimiterList = new ArrayList<>();
    private String customDelimiter;

    public Delimiter(String inputString) {
        this.inputString = inputString;
        setDefaultDelimiter();
    }

    private void setDefaultDelimiter() {
        delimiterList.addAll(DefaultDelimiter.getDefaultDelimiters());
    }

    private void setCustomDelimiter() {
        int delimiterEndIndex = inputString.indexOf("\\n");

        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException("올바른 형식의 커스텀 구분자가 아닙니다.");
        }

        customDelimiter = inputString.substring(2, delimiterEndIndex);
        validateCustomDelimiter();

        delimiterList.add(escapeSpecialRegexChars(customDelimiter));
        inputString = inputString.substring(delimiterEndIndex + 2);
    }

    private void validateCustomDelimiter() {
        if (customDelimiter.length() != 1 || customDelimiter.trim().isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자는 한 글자만 허용됩니다.");
        }

        if (Character.isDigit(customDelimiter.charAt(0))) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 될 수 없습니다.");
        }
    }

    private void checkCustomDelimiter() {
        if (inputString.startsWith("//")) {
            setCustomDelimiter();
        }
    }

    public String[] splitString() {
        checkCustomDelimiter();
        if (inputString == null || inputString.trim().isEmpty()) {
            return null;
        }
        String delimiterRegex = String.join("|", delimiterList); // ",|:|customDeli"
        return inputString.split(delimiterRegex);
    }

    private String escapeSpecialRegexChars(String delimiter) {
        return delimiter.replaceAll("([\\[\\]\\\\.^$|?*+(){}])", "\\\\$1");
    }

    public String getCustomDelimiter() {
        return customDelimiter;
    }
}
