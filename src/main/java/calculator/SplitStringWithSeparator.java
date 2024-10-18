package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitStringWithSeparator {
    public List<String> processedInput = new ArrayList<>();

    public void splitWithDefaultSeparator(CalculatorIO calculatorIO) {
        String delimiter = "[,:]";
        String[] splitInput = calculatorIO.userInput.split(delimiter);
        processedInput.addAll(Arrays.asList(splitInput));
    }

    public void splitWithCustomSeparator(CalculatorIO calculatorIO, Integer escapeIdx) {
        String separator = calculatorIO.userInput.substring(0, escapeIdx);

        if (separator.startsWith("//")) {
            separator = separator.replace("//", "");
        }

        String leftInput = calculatorIO.userInput.substring(escapeIdx + 2);
        String[] splitInput = leftInput.split(separator);
        processedInput.addAll(Arrays.asList(splitInput));
    }
}
