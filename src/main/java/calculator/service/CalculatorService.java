package calculator.service;

import calculator.controller.InputController;

public class CalculatorService {

    private int result = 0;

    public void validate(String input) {
        if (input.contains("\\n")) {
            input = input.substring(input.indexOf("\\n") + 2);
        }
        if (isThereWrongValue(input)) {
            throw new IllegalArgumentException("잘못된 값이 입력 되었습니다.");
        }
        if (isWrongEquation(input)) {
            throw new IllegalArgumentException("잘못된 수식 입니다.");
        }
    }

    private boolean isThereWrongValue(String input) {
        boolean wrongValue = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isDigit(c)) {
                continue;
            }
            boolean pass = true;
            for (String delimiter : InputController.getDelimiterList()) {
                for (int j = 0; j < delimiter.length(); j++) {
                    if (input.charAt(i + j) != delimiter.charAt(j)) {
                        pass = false;
                        break;
                    } else {
                        pass = true;
                    }
                }
                if (pass) {
                    i += delimiter.length() - 1;
                    break;
                }
            }
            if (pass) {
                continue;
            }
            wrongValue = true;
        }
        return wrongValue;
    }

    private boolean isWrongEquation(String input) {
        boolean wrongEquation = false;
        if (!isDigit(input.charAt(0)) || !isDigit(input.charAt(input.length() - 1))) {
            return true;
        }
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!isDigit(ch)) {
                for (String delimiter : InputController.getDelimiterList()) {
                    if (input.startsWith(delimiter, i)) {
                        if (!isDigit(input.charAt(i - 1)) || !isDigit(input.charAt(i + delimiter.length()))) {
                            wrongEquation = true;
                        }
                    }
                }
            }
        }
        return wrongEquation;
    }

    private boolean isDigit(char c) {
        return (c > 47 && c < 58);
    }

    public void calculate(String input) {
        for (char ch : input.toCharArray()) {
            if (isDigit(ch)) {
                result += ch - '0';
            }
        }
    }

    public int getResult() {
        return result;
    }

    public void resetResult() {
        result = 0;
    }
}
