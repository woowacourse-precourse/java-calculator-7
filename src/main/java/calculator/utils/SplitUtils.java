package calculator.utils;

import calculator.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitUtils {
    public static List<String> getCalculationSection(String userInput) {
         List<String> calculationSection = new ArrayList<>();

        if (userInput.isEmpty()) {
            return calculationSection;
        }

        if (isUsingCustomDelimiter(userInput)) {
            return splitWithCustomDelimiter(userInput);
        }

        return splitWithDefaultDelimiter(userInput);
    }

    private static List<String> splitWithDefaultDelimiter(String userInput) {
        String delimiter = "[,:]";
        String[] calculationSection = userInput.split(delimiter);

        return Arrays.asList(calculationSection);
    }

    private static List<String> splitWithCustomDelimiter(String userInput) {
        int customEscapeIndex = getCustomEscapeIndex(userInput);
        String delimiter = userInput.substring(0, customEscapeIndex);

        if (delimiter.startsWith("//")) {
            delimiter = delimiter.replace("//", "");
        }

        if (ValidateUtils.isNumeric(delimiter)) {
            throw new IllegalArgumentException(ErrorMessage.CAN_USE_ONLY_STRING.getMessage());
        }

        String customSection = userInput.substring(customEscapeIndex + 2);
        String[] calculationSection = customSection.split(delimiter);

        return Arrays.asList(calculationSection);
    }

    private static int getCustomEscapeIndex(String userInput) {
        return userInput.indexOf("\\n");
    }

    private static boolean isUsingCustomDelimiter(String userInput) {
        int customEscapeIndex = getCustomEscapeIndex(userInput);
        return customEscapeIndex > 0;
    }
}
