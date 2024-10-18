package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitStringWithSeparator {
    public List<String> processedInput = new ArrayList<>();

    public void splitWithDefaultSeparator(String userInput) {
        String delimiter = "[,:]";
        String[] splitInput = userInput.split(delimiter);
        processedInput.addAll(Arrays.asList(splitInput));
    }

    public void splitWithCustomSeparator(String userInput, int escapeIdx) {
        String separator = userInput.substring(0, escapeIdx);

        if (separator.startsWith("//")) {
            separator = separator.replace("//", "");
        }

        String leftInput = userInput.substring(escapeIdx + 2);
        String[] splitInput = leftInput.split(separator);
        processedInput.addAll(Arrays.asList(splitInput));
    }
}
