package calculator.controller;

import calculator.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Process {

    private final InputView inputView =  new InputView();
    private String userInput;
    private List<Character> basicSeparator = new ArrayList<>(Arrays.asList(':', ','));

    public boolean isSeparator() {
        if (userInput.startsWith("//") && userInput.contains("\\n")) {
            return true;
        }
        return false;
    }

    public String findSeparator() {
        int startIndex = 2;
        int endIndex = userInput.lastIndexOf("\\n");

        return userInput.substring(startIndex, endIndex);
    }

}








