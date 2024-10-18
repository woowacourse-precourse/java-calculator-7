package calculator.controller;

import calculator.utils.InputCase;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CalculatorController {

    public void calculate() {
        String input = InputView.getInput();
        //input format 점검
        Stream<Integer> numbers = convertString(input);

        int sum = numbers.reduce(0, Integer::sum);

        OutputView.printResult(sum);
    }

    private Stream<Integer> convertString(String input) {
        String[] stringNums = extractStringNumber(input);

        if (Arrays.asList(stringNums).contains("")) {
            throw new IllegalArgumentException("구분자가 잘못 입력되었습니다.");
        }

        return extractNumber(stringNums);
    }

    private String[] extractStringNumber(String input) {
        InputCase inputCase = separateCase(input);
        return switch(inputCase) {
            case InputCase.NONE -> new String[0];
            case InputCase.DEFAULT -> input.replaceAll("[,|:]", " ")
                    .split(" ");
            case InputCase.CUSTOM -> {
                String customDelimiter = extractNewDelimiter(input);
                String slicedInput = input.substring(customDelimiter.length() + 4); // 4 == "//\n".length()
                yield slicedInput.replaceAll("[,|:|" + customDelimiter+ "]", " ")
                        .split(" ");
            }
        };
    }

    private InputCase separateCase(String input) {
        if (input.matches("")) {
            return InputCase.NONE;
        } else if (startsWithNumber(input)) {
            return InputCase.DEFAULT;
        } else {
            return InputCase.CUSTOM;
        }
    }

    private Stream<Integer> extractNumber(String[] stringNums) {
        try {
           return Arrays.stream(stringNums).map(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 입력값이 있습니다.");
        }
    }

    private String extractNewDelimiter(String str) {
        int indexOfFormatLast = str.indexOf("\\n");
        return str.substring(2, indexOfFormatLast);
    }

    private boolean checkInputFormat(String str) {
        if(!str.startsWith("//")) throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
        if(!str.contains("\\n")) throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
        return true;
    }

    private boolean startsWithNumber(String str) {
        String first = String.valueOf(str.charAt(0));
        return first.matches("[0-9]+");
    }

    private Stream<Integer> convertToInt(List<String> strs) {
        return strs.stream().map(Integer::parseInt);
    }
}


