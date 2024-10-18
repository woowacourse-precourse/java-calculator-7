package calculator.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitUtils {
    public static List<String> getSplitInput(String userInput) {
        List<String> processedInput = new ArrayList<>();

        int escapeIdx = userInput.indexOf("\\n");
        if (escapeIdx > 0) {
            processedInput = splitWithCustomSeparator(userInput, escapeIdx);
        } else {
            processedInput = splitWithDefaultSeparator(userInput);
        }

        return processedInput;
    };

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

        String leftInput = userInput.substring(escapeIdx + 2);
        String[] splitInput = leftInput.split(separator);

        return Arrays.asList(splitInput);
    }
}
