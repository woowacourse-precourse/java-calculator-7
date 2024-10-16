package calculator.controller;

import calculator.model.InputString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParsingInputString {

    public List<String> parsingInput(InputString inputString) {
        String splitString = "[,:" + inputString.getCustomChar() + "]";
        List<String> numberStringList = Arrays.stream(inputString.getInput().split(splitString))
            .toList();
        Validation.verifyInput(numberStringList);
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
