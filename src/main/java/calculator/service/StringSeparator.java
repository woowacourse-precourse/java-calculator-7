package calculator.service;

import calculator.domain.Calculator;

public class StringSeparator {

    private Calculator calculator;

    public StringSeparator(Calculator calculator) {
        this.calculator = calculator;
    }

    public void divideSeparator(String str) {
        if (str.startsWith("//")) {
            String divide = "";
            int customEndIndex = 0;
            for (int i = 0; i < str.length(); i++) {
                divide += str.charAt(i);
                if (divide.contains("\\n")) {
                    break;
                }
            }
            if (!isWrongInput(divide)) {
                customEndIndex = divide.length();
            } else {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            String customSeparator = extractionCustomSeparator(divide);
            calculator.addSeparator(customSeparator);
            str = str.substring(customEndIndex);
        }
        String number = "";
        String separator = "";
        for (int i = 0; i < str.length(); i++) {
            char nowChar = str.charAt(i);
            if (isNumber(nowChar)) {
                if (!separator.isEmpty() && !isSeparator(separator)) {
                    calculator.addSeparator(separator);
                    separator = "";
                }
                number += nowChar;
            } else {
                if (!number.isEmpty()) {
                    calculator.addNumber(Integer.parseInt(number));
                    number = "";
                }
                separator += nowChar;
            }
        }
        if (!number.isEmpty()) {
            calculator.addNumber(Integer.parseInt(number));
        }
    }

    private boolean isNumber(char ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }

    private boolean isWrongInput(String divide) {
        if (divide == null || divide.length() < 5) {
            return true;
        }
        if (!divide.startsWith("//") || !divide.contains("\\n")) {
            return true;
        }
        return false;
    }

    public String extractionCustomSeparator(String divide) {
        return divide.substring(2, divide.indexOf("\\n"));
    }

    private boolean isSeparator(String str) {
        if (calculator.getSeparators().contains(String.valueOf(str))) {
            return true;
        }
        return false;
    }

}
