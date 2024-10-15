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
}
