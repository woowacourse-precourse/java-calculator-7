package calculator.controller;

import calculator.model.InputString;
import java.util.Arrays;
import java.util.List;

public class ParsingInputString {

    public static InputString parsingInput(InputString inputString) {
        if (inputString.isEmpty()) {
            return new InputString(inputString.input(), inputString.splitString(), List.of("0"));
        }
        List<String> numberStringList = Arrays.stream(inputString.input().split(
                inputString.splitString()))
            .toList();
        if (!inputString.isNumber(numberStringList)) {
            throw new IllegalArgumentException("잘못된 입력값 입니다.");
        }
        return new InputString(inputString.input(), inputString.splitString(),
            numberStringList);
    }
}
