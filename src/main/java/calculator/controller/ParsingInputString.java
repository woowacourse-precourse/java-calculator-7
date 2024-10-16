package calculator.controller;

import calculator.model.InputString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParsingInputString {

    private static final int beginIndex = 5;
    private static final int beginCustomIndex = 0;
    private static final int endCustomIndex = 3;
    private static final int CustomCharIndex = 2;

    public void findCustomChar(InputString inputString) {
        String input = inputString.getInput();
        if (input.length() < 4) {
            return;
        }

        if (input.indexOf("//") == beginCustomIndex && input.indexOf("\\n") == endCustomIndex) {
            inputString.setCustomChar(input.charAt(CustomCharIndex));
            inputString.setInput(input.substring(beginIndex));
        } else if (input.indexOf("//") == beginCustomIndex
            && input.indexOf("\\n") == endCustomIndex - 1) {
            inputString.setInput(input.substring(beginIndex - 1));
        }
    }

    public List<String> parsingInput(InputString inputString) {
        String splitString = "[,:" + inputString.getCustomChar() + "]";
        List<String> numberStringList = Arrays.stream(inputString.getInput().split(splitString))
            .toList();
        Validation.VerifyInput(numberStringList);
        return numberStringList;
    }

    public List<Integer> getNumberList(InputString inputString, List<String> numberStringList) {
        List<Integer> numberList = new ArrayList<>();
        for (String s : numberStringList) {
            numberList.add(Integer.valueOf(s));
        }

        inputString.setNumberList(numberList);
        return numberList;
    }
}
