package calculator.service;

import calculator.model.Delimiter;

import java.util.ArrayList;

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
}
