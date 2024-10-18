package calculator.controller;

import calculator.model.Input;
import java.util.Arrays;
import java.util.List;

public class InputDivider {

    public static Input divideInput(Input input) {
        if (input.isOriginEmpty()) {
            return Input.makeInputWithoutOrigin(input);
        }
        List<String> numbers = Arrays
                .stream(input.origin().split(input.separator()))
                .toList();
        return Input.makeInputWithOrigin(input, numbers);
    }
}
