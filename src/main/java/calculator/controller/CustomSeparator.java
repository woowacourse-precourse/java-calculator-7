package calculator.controller;

import calculator.model.Input;

public class CustomSeparator {

    public static Input findCustomSeparator(Input input) {
        String origin = input.origin();
        if (isAgainstCustomLengthRule(origin)) {
            return input;
        }
        if (hasCustomSeparator(origin)) {
            return new Input(origin.substring(5), "[,:" + origin.charAt(2) + "]",
                    input.numbers());
        }
        if (notHasCustomSeparator(origin)) {
            return new Input(origin.substring(4), input.separator(),
                    input.numbers());
        }
        return input;
    }

    private static boolean notHasCustomSeparator(String origin) {
        return origin.indexOf("//") == 0 && origin.indexOf("\\n") == 2;
    }

    private static boolean hasCustomSeparator(String origin) {
        return origin.indexOf("//") == 0 && origin.indexOf("\\n") == 3;
    }

    private static boolean isAgainstCustomLengthRule(String origin) {
        return origin.length() < 4;
    }

}
