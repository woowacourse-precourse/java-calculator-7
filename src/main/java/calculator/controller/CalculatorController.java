package calculator.controller;

import calculator.controller.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CalculatorController {
    public void start() {
        String input = InputView.getIdentifierAndNumbers();
        String[] stringArray = input.split("");
        List<Integer> numbers = new ArrayList<>();
        List<String> identifiers = new ArrayList<>();
        if (isNumber(stringArray[0])) {
            List<String> numStrs = new ArrayList<>();
            for (int i = 0; i < stringArray.length; i++) {
                if (i % 2 == 0) {
                    numStrs.add(stringArray[i]);
                } else {
                    identifiers.add(stringArray[i]);
                }
            }

            if(identifiers.stream().allMatch(identifier ->
                    identifier.equals(",") || identifier.equals(":"))) {
                numbers = convertToInt(numStrs).toList();
            }
        } else {

        }
        int sum = numbers.stream().reduce(0, Integer::sum);
    }

    private Boolean isNumber(String str) {
        return str.matches("[0-9]+");
    }

    private Stream<Integer> convertToInt(List<String> strs) {
        return strs.stream().map(Integer::parseInt);
    }
}
