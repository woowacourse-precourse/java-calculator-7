package calculator.model;

import java.util.ArrayList;

public class Delimiter {
    private String inputString;
    private ArrayList<String> delimiterList = new ArrayList<>();
    private String customDelimiter;

    public Delimiter(String inputString) {
        this.inputString = inputString;
        delimiterList.add(",");
        delimiterList.add(":");
    }

    public void setCustomDelimiter() {
        int delimiterEndIndex = inputString.indexOf("\\n");

        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException("올바른 형식의 커스텀 구분자가 아닙니다.");
        }

        customDelimiter = inputString.substring(2, delimiterEndIndex);

        if (customDelimiter.length() != 1 || customDelimiter.trim().isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자는 한 글자만 허용됩니다.");
        }

        if (Character.isDigit(customDelimiter.charAt(0))) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 될 수 없습니다.");
        }

        delimiterList.add(escapeSpecialRegexChars(customDelimiter));
        inputString = inputString.substring(delimiterEndIndex + 2);
    }


    // Controller 에서 Delimiter 객체 생성 후 사용 (커스텀 구분자 존재 여부 확인)
    public void checkCustomDelimiter() {
        if (inputString.startsWith("//")) {
            setCustomDelimiter();
        }
    }

    public String[] splitString() {
        if (inputString == null || inputString.trim().isEmpty()) {
            return null;
        }
        String delimiterRegex = String.join("|", delimiterList); // ",|:|customDeli"
        return inputString.split(delimiterRegex);
    }

    private String escapeSpecialRegexChars(String delimiter) {
        return delimiter.replaceAll("([\\[\\]\\\\.^$|?*+(){}])", "\\\\$1");
    }
}
