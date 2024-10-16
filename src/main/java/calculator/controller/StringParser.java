package calculator.controller;

import calculator.model.Numbers;
import calculator.model.UserInput;
import java.util.Arrays;
import java.util.List;

public class StringParser {
    public Numbers parse(UserInput input) {
        String[] strParts = input.getInputString().split("[,:]");
        List<Integer> numbers = Arrays.stream(strParts)
                .map(Integer::parseInt)
                .toList();
        return new Numbers(numbers);
    }
}
