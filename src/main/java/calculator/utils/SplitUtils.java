package calculator.utils;

import calculator.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitUtils {
    public static List<String> getSplitInput(String userInput) {
        List<String> processedInput = new ArrayList<>();
        int escapeIdx = userInput.indexOf("\\n");

        if (userInput.isEmpty()) {
            return processedInput;
        }

        if (isUsingCustomSeparator(escapeIdx)) {
            return splitWithCustomSeparator(userInput, escapeIdx);
        }

        return splitWithDefaultSeparator(userInput);
    }

    private static boolean isUsingCustomSeparator(int escapeIdx) {
        return escapeIdx > 0;
    }

    private static List<String> splitWithDefaultSeparator(String userInput) {
        String delimiter = "[,:]";
        String[] splitInput = userInput.split(delimiter);

        return Arrays.asList(splitInput);
    }

    private static List<String> splitWithCustomSeparator(String userInput, int escapeIdx) {
        String separator = userInput.substring(0, escapeIdx);

        if (separator.startsWith("//")) {
            separator = separator.replace("//", "");
        }

        if (ValidateUtils.isNumeric(separator)) {
            throw new IllegalArgumentException(ErrorMessage.CAN_USE_ONLY_STRING.getMessage());
        }

        String leftInput = userInput.substring(escapeIdx + 2);
        String[] splitInput = leftInput.split(separator);

        return Arrays.asList(splitInput);
    }
}
