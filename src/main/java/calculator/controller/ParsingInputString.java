package calculator.controller;

import calculator.model.InputString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParsingInputString {

    private final InputString inputString;
    private static final int beginIndex = 5;

    public ParsingInputString(InputString inputString) {
        this.inputString = inputString;
    }

    public void findCustomChar() {
        String input = inputString.getInput();
        if (input.length() < 4) {
            return;
        }
        if (input.indexOf("//") == 0 && input.indexOf("\\n") == 3) {
            inputString.setCustomChar(input.charAt(2));
            inputString.setInput(input.substring(beginIndex));
        }
    }

    public List<Integer> parsingInput() {
        String splitString = "[,:" + inputString.getCustomChar() + "]";
        List<String> numberStringList = Arrays.stream(inputString.getInput().split(splitString))
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
