package calculator.model;


import calculator.exception.Exceptions;

import java.util.ArrayList;
import java.util.List;

public class InputString {

    private String inputString;
    private List<String> customDelimiter = new ArrayList();

    public InputString(String inputString) {
        this.inputString = inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public String getInputString() {
        return inputString;
    }

    public List<String> getCustomDelimiter() {
        return customDelimiter;
    }

    public void addCustomDelimiter(String input) {
        this.customDelimiter.add(input);
    }


}
