package calculator.util;

import calculator.domain.CustomDelimiter;
import calculator.domain.DefaultDelimiter;
import java.util.Arrays;
import java.util.List;

public class Splitter {

    private static final String CUSTOM_TAG = "(//|\\\\n)";
    private static final int CUSTOM_NUMBER_PART = 2;
    private static final int DEFAULT_NUMBER_PART = 0;

    public static String[] splitOut(String input) {
        String[] splitInput = input.split(CUSTOM_TAG);

        return splitInput;
    }

    public static List<String> splitToCustom(CustomDelimiter custom, String[] numberString) {
        return Arrays.stream(
                        numberString[CUSTOM_NUMBER_PART].split(custom.getDelimiter()))
                .toList();
    }

    public static List<String> splitToDefault(String[] numberString) {
        return Arrays.stream(
                        numberString[DEFAULT_NUMBER_PART].split(
                                DefaultDelimiter.FIRST.getDelimiter() + "|" + DefaultDelimiter.SECOND.getDelimiter()))
                .toList();
    }
}