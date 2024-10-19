package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringHandler {
    public String extractSeparator(String input) {
        int start = input.indexOf("//") + 2;
        int end = input.indexOf("\n");
        return input.substring(start, end);
    }

    public List<String> getNumbers(List<String> separators, String input) {
        List<String> splitInput = new ArrayList<>(Arrays.asList(input));

        for (String separator : separators) {
            List<String> tempResult = new ArrayList<>();
            for (String part : splitInput) {
                tempResult.addAll(Arrays.asList(part.split(separator)));
            }
            splitInput = tempResult;
        }
        return splitInput;
    }

    public String removeCustom(String input) {
        int end = input.indexOf("\n") + 1;
        return input.substring(end);
    }
}
