package calculator.controller;

import calculator.utils.InputCase;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.Arrays;
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

        // ",", ":", 커스텀 구분자 외 구분자가 사용되면 빈 스트링이 존재함
        if (Arrays.asList(stringNums).contains("")) {
            throw new IllegalArgumentException("구분자가 잘못 입력되었습니다.");
        }

        return convertToNumber(stringNums);
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
        } else if (startsWithPositiveNumber(input)) {
            return InputCase.DEFAULT;
        } else if (isCustomFormat(input)) {
            return InputCase.CUSTOM;
        } else {
            throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
        }
    }

    private Stream<Integer> convertToNumber(String[] stringNums) {
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

    private boolean isCustomFormat(String str) {
        if(!str.startsWith("//")) throw new IllegalArgumentException("커스텀 구분자 입력은 //으로 시작해야합니다.");
        if(!str.contains("\\n")) throw new IllegalArgumentException("커스텀 구분자는 입력은 \\n 로 끝나야합니다.");
        return true;
    }

    private boolean startsWithPositiveNumber(String str) {
        if (str.matches("[1-9].*")) {
            return true;
        } else throw new IllegalArgumentException("숫자는 양수만 입력할 수 있습니다.");
    }
}


