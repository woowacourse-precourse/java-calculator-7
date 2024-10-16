package calculator.service;

import calculator.domain.Calculator;

public class StringSeparator {

    private Calculator calculator;

    public StringSeparator(Calculator calculator) {
        this.calculator = calculator;
    }

    public void divideSeparator(String str) {
        String number = "";
        String divide = "";
        for (int i = 0; i < str.length(); i++) {
            if (isNumber(str.charAt(i))) {
                if (!divide.isEmpty()) {
                    if (isWrongInput(divide)) {
                        throw new IllegalArgumentException("잘못된 입력입니다.");
                    } else {
                        String separator = extractionSeparator(divide);
                        calculator.addSeparator(separator);
                        divide = "";
                    }
                }
                number += str.charAt(i);
            } else {
                if (isSeparator(str.charAt(i))) {
                    if (!number.isEmpty()) {
                        calculator.addNumber(Integer.parseInt(number));
                        number = "";
                    }
                } else {
                    divide += str.charAt(i);
                }
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
        if (divide.charAt(0) != '/' || divide.charAt(1) != '/' || divide.charAt(divide.length() - 1) != '\n'
                || divide.length() < 4) {
            return true;
        }
        return false;
    }

    public String extractionSeparator(String divide) {
        return divide.substring(2, divide.length() - 1);
    }

    private boolean isSeparator(char ch) {
        if (calculator.getSeparators().contains(String.valueOf(ch))) {
            return true;
        }
        return false;
    }

}
