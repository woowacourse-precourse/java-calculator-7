package calculator.controller;

import calculator.model.Input;

public class CustomSeparator {

    public static Input findCustomSeparator(Input input) {
        if (input.isAgainstCustomLengthRule()) {
            return input;
        }
        if (input.hasCustomSeparator()) {
            return input.makeInputWithSeparator();
        }
        if (input.notHasCustomSeparator()) {
            return input.makeInputWithoutSeparator();
        }
        return input;
    }
}
