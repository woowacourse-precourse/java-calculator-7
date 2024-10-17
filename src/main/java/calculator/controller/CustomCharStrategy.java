package calculator.controller;

import calculator.model.InputString;

public class CustomCharStrategy {

    public static InputString findCustomChar(InputString inputString) {
        String input = inputString.input();
        if (input.length() < 4) {
            return inputString;
        }
        if (input.indexOf("//") == 0 && input.indexOf("\\n") == 3) {
            return new InputString(input.substring(5), "[,:" + input.charAt(2) + "]",
                inputString.numberList());
        }
        if (input.indexOf("//") == 0 && input.indexOf("\\n") == 2) {
            return new InputString(input.substring(4), inputString.splitString(),
                inputString.numberList());
        }
        return inputString;
    }
}
