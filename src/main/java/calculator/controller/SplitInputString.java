package calculator.controller;

import calculator.model.Input;
import java.util.Arrays;
import java.util.List;

public class SplitInputString {

    public static Input SplitString(Input input) {
        if (input.isEmpty()) {
            return new Input(input.origin(), input.separator(), List.of("0"));
        }
        List<String> numberStringList = Arrays.stream(input.origin().split(
                        input.separator()))
                .toList();
        if (!input.isNumber(numberStringList)) {
            throw new IllegalArgumentException("잘못된 입력값 입니다.");
        }
        return new Input(input.origin(), input.separator(),
                numberStringList);
    }
}
