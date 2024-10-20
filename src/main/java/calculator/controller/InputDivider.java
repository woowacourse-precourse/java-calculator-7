package calculator.controller;

import calculator.model.Input;

public class InputDivider {

    public static Input divideInput(Input input) {
        if (input.isOriginEmpty()) {
            return input.makeInputWithoutOrigin();
        }
        return input.makeInputWithOrigin();
    }
}
