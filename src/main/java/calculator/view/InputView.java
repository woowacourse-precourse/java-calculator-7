package calculator.view;

import static calculator.global.Message.INPUT_MESSAGE;
import static calculator.global.Seperator.COLON;
import static calculator.global.Seperator.COMMA;
import static calculator.global.Seperator.CUSTOM;
import static calculator.global.error.ErrorCode.NOT_POSITIVE_ERROR_MESSAGE;
import static calculator.global.error.ErrorCode.NUMERIC_ERROR_MESSAGE;

import calculator.global.error.NumericError;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String DOUBLE_SLASH = "\\Q//";
    private static final String NEW_LINE = "\\n";
    private static final String DOUBLE_REGEX = "^-?\\d+(\\.\\d+)?$";
    private static final String REGEX_QUOTE_START = "\\Q";
    private static final String REGEX_QUOTE_END = "\\E";

    public static String receiveInput() {
        System.out.println(INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static List<Double> getNumber(String input) {

        List<String> numbers = splitInput(removeUnUsedSentence(input));
        validate(numbers);
        return typeConvert(numbers);
    }

    public static List<String> splitInput(List<String> input) {

        return input.stream()
                .flatMap(str -> Arrays.stream(str.split(getRegex())))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

    private static String getRegex() {
        return COMMA.getSeperator() + "|"
                + COLON.getSeperator() + "|"
                + REGEX_QUOTE_START
                + CUSTOM.getSeperator()
                + REGEX_QUOTE_END;
    }

    private static void validate(List<String> numbers) {
        
        validateNumber(numbers);
        validatePositiveNumber(numbers);
    }

    public static void validatePositiveNumber(List<String> numbers) {

        boolean validate = numbers.stream().allMatch(number -> (Double.parseDouble(number) > 0));

        if (!validate) {
            throw new NumericError(NOT_POSITIVE_ERROR_MESSAGE);
        }
    }

    public static void validateNumber(List<String> numbers) {

        boolean validate = numbers.stream().allMatch(number -> number.matches(DOUBLE_REGEX));

        if (!validate) {
            throw new NumericError(NUMERIC_ERROR_MESSAGE);
        }
    }

    private static List<Double> typeConvert(List<String> numbers) {
        return numbers.stream()
                .filter(number -> !number.isEmpty())
                .map(number -> Double.parseDouble(number))
                .collect(Collectors.toList());
    }

    public static List<String> removeUnUsedSentence(String input) {

        return Arrays.asList(input.split(DOUBLE_SLASH + CUSTOM.getSeperator() + NEW_LINE))
                .stream()
                .filter(sentence -> !sentence.isEmpty())
                .collect(Collectors.toList());
    }
}
