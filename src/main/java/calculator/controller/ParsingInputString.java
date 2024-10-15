package calculator.controller;

import calculator.model.InputString;

public class ParsingInputString {

    private InputString inputString;

    public String setInputString(String initString) {
        try {
            if (initString.charAt(0) != '"'
                || initString.charAt(initString.length() - 1) != '"') {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        } catch (IllegalArgumentException e) {
            System.exit(0);
        }
        inputString.setInput(initString.substring(1, initString.length() - 1));

        return inputString.getInput();
    }
}
