package calculator.util;

import calculator.domain.CustomDelimiter;
import calculator.domain.DefaultDelimiter;
import java.util.Arrays;
import java.util.List;

public class Parser {

    private static final String CUSTOM_STYLE_TAG = "(//|\\\\n)";
    private static final int CUSTOM_NUMBER_PART = 2;
    private static final int DEFAULT_NUMBER_PART = 0;

    public static String[] splitOutByCustomStyle(String input) {
        String[] splitInput = input.split(CUSTOM_STYLE_TAG);

        return splitInput;
    }

    public static List<String> parseToCustom(CustomDelimiter custom, String[] numberString) {
        return Arrays
                .stream(numberString[CUSTOM_NUMBER_PART].split(custom.getDelimiter()))
                .toList();
    }

    public static List<String> parseToDefault(String[] numberString) {
        return Arrays
                .stream(numberString[DEFAULT_NUMBER_PART].split(
                        DefaultDelimiter.FIRST.getDelimiter() + "|" + DefaultDelimiter.SECOND.getDelimiter()))
                .toList();
    }
}