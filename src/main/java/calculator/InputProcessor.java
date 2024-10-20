package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputProcessor {
    private static InputProcessor instance;

    private InputProcessor() {
    }

    public static InputProcessor getInstance() {
        if (instance == null) {
            instance = new InputProcessor();
        }
        return instance;
    }

    ExceptionHandler exceptionHandler = ExceptionHandler.getInstance();

    public List<Integer> getInputFromUser() {
        String input = Console.readLine();
        List<String> delimiters = makeBasicDelimiters();
        char customDelim = '0';
        boolean customDelimFlag = isInputHasCustomDelim(input);

        if (customDelimFlag) {
            delimiters.add(getCustomDelim(input));
            input = input.substring(5);
            customDelim = delimiters.getLast().charAt(0);
        }

        validateIsInputIncorrect(input, customDelimFlag, customDelim);
        List<String> splitElems = makeSplitElemsList(input, delimiters);

        return makeNumsList(splitElems);
    }

    private boolean isInputHasCustomDelim(String input) {
        if (input.charAt(0) == '/') {
            for (int i = 0; i < 2; i++) {
                exceptionHandler.checkIncorrectDelimGenerateInput(input.charAt(i));
            }

            for (int i = 3; i < 5; i++) {
                exceptionHandler.checkIncorrectDelimGenerateInput(input.charAt(i));
            }

            return true;
        }

        return false;
    }

    private String getCustomDelim(String input) {
        char delim = input.charAt(2);
        exceptionHandler.checkIncorrectDelim(delim);

        return String.valueOf(delim);
    }

    private void validateIsInputIncorrect(String input, boolean customDelimFlag, char customDelim) {
        if (customDelimFlag) {
            exceptionHandler.checkIncorrectInputWithCustomDelim(input.toCharArray(), customDelim);
            return;
        }

        exceptionHandler.checkIncorrectInputWithoutCustomDelim(input.toCharArray());
    }

    private List<String> makeSplitElemsList(String input, List<String> delimiters) {
        String regex = makeRegex(delimiters);
        String[] split = input.split(regex);

        return Arrays.asList(split);
    }

    private List<Integer> makeNumsList(List<String> splitElems) {
        List<Integer> nums = splitElems.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        exceptionHandler.checkZeroAndNegativeDigit(nums);

        return nums;
    }

    private List<String> makeBasicDelimiters() {
        return new ArrayList<>(){{
            add(",");
            add(":");
        }};
    }

    private String makeRegex(List<String> delimiters) {
        StringBuilder regex = new StringBuilder();

        regex.append("[");
        for (String delim : delimiters) {
            regex.append(delim);
        }
        regex.append("]");

        return regex.toString();
    }
}
