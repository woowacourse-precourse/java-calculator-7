package calculator.service;

import calculator.model.Delimiter;

public class StringSplit {

    private String inputString;
    Delimiter delimiter = new Delimiter();


    public StringSplit(String inputString) {
        this.inputString = inputString;
    }

    public void preprocessDelimiter() {
        findCustomDelimiter();
        takeOffCustomDelimiter();
    }

    private void findCustomDelimiter() {
        if (inputString.startsWith("//")) {
            char newDelimiter = inputString.charAt(2);
            delimiter.addCustomDelimiter(newDelimiter);
        }
    }

    private void takeOffCustomDelimiter() {
        if (inputString.startsWith("//")) {
            inputString = inputString.substring(5);
        }
    }

    public void splitAndSaveOperands() {
        String[] stringOperands = splitOperands();
    }

    private String[] splitOperands() {
        String reg = "";
        for (Character delimiter : delimiter.getDelimiters()) {
            reg += ("\\" + delimiter + "|");
        }
        if (!reg.isEmpty()) {
            reg = reg.substring(0, reg.length() - 1);
        }
        return inputString.split(reg);
    }
}
