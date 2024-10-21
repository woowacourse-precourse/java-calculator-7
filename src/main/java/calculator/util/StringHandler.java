package calculator.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringHandler {
    public String extractSeparator(String input) {
        int start = Constants.CUSTOM_PREFIX.length() ;
        int end = input.indexOf(Constants.CUSTOM_SUFFIX);
        return input.substring(start, end);
    }

    public List<String> getNumbers(List<String> separators, String input) {
        List<String> splitInput = new ArrayList<>();
        splitInput.add(input);

        for (String separator : separators) {
            splitInput = splitBySeparator(splitInput, separator);
        }

        return splitInput;
    }

    private List<String> splitBySeparator(List<String> inputList, String separator) {
        List<String> result = new ArrayList<>();

        for (String part : inputList) {
            String[] splitParts = part.split(separator);
            result.addAll(Arrays.asList(splitParts));
        }

        return result;
    }

    public String removeCustom(String input) {
        int numberIndex = input.indexOf(Constants.CUSTOM_SUFFIX) + 2;
        return input.substring(numberIndex);
    }
}
