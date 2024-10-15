package calculator.controller;

import calculator.model.InputString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParsingInputString {

    private InputString inputString;

    public ParsingInputString(InputString inputString) {
        this.inputString = inputString;
    }

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
