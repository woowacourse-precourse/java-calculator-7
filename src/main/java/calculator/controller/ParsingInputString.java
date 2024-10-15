package calculator.controller;

import calculator.model.InputString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParsingInputString {

    private final InputString inputString;

    public ParsingInputString(InputString inputString) {
        this.inputString = inputString;
    }

    public List<Integer> parsingInput() {
        String splitString = "[,:" + inputString.getCustomChar() + "]";
        List<String> numberStringList = Arrays.stream(inputString.getInput().split(splitString))
            .toList();
        List<Integer> numberList = new ArrayList<>();
        for (String s : numberStringList) {
            numberList.add(Integer.valueOf(s));
        }
        inputString.setNumberList(numberList);
        return numberList;
    }

    public void findCustomChar() {
        String input = inputString.getInput();
        if (input.charAt(0) == '/' && input.charAt(1) == '/'
            && input.charAt(3) == '\\' && input.charAt(4) == 'n') {
            inputString.setCustomChar(input.charAt(2));
        }
    }
}
