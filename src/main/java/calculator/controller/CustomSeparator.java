package calculator.controller;

import calculator.model.Input;

public class CustomSeparator {

    public static Input findCustomSeparator(Input input) {
        String origin = input.origin();
        if (IsAgainstCustomLengthRule(origin)) {
            return input;
        }
        if (origin.indexOf("//") == 0 && origin.indexOf("\\n") == 3) {
            return new Input(origin.substring(5), "[,:" + origin.charAt(2) + "]",
                    input.numbers());
        }
        if (origin.indexOf("//") == 0 && origin.indexOf("\\n") == 2) {
            return new Input(origin.substring(4), input.separator(),
                    input.numbers());
        }
        return input;
    }

    private static boolean IsAgainstCustomLengthRule(String origin) {
        return origin.length() < 4;
    }

}
