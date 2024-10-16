package calculator.controller;

import calculator.model.InputString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParsingInputString {

    private final InputString inputString;
    private static final int beginIndex = 5;
    private static final int beginCustomIndex = 0;
    private static final int endCustomIndex = 3;
    private static final int CustomCharIndex = 2;

    public ParsingInputString(InputString inputString) {
        this.inputString = inputString;
    }

    public void findCustomChar() {
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

    public List<Integer> parsingInput() {
        String splitString = "[,:" + inputString.getCustomChar() + "]";
        String input = inputString.getInput();

        if (Validation.VerifyStringEmpty(input)) {
            inputString.setNumberList(List.of(0));
            return List.of(0);
        }

        List<String> numberStringList = Arrays.stream(input.split(splitString))
            .toList();

        Validation.VerifyInput(numberStringList);

        List<Integer> numberList = new ArrayList<>();
        for (String s : numberStringList) {
            numberList.add(Integer.valueOf(s));
        }

        inputString.setNumberList(numberList);
        return numberList;
    }
}
