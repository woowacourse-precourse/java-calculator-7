package calculator.model;

import java.util.List;

public class InputString {

    private String input;
    private char customChar;
    private List<Integer> numberList;

    public InputString(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public char getCustomChar() {
        return customChar;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setCustomChar(char customChar) {
        this.customChar = customChar;
    }

    public void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }
}
