package calculator.Utils;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    public static List<String> splitByDelimiter(String userInput, String delimiter) {
        String[] splitedInput = userInput.split(delimiter);
        return Arrays.stream(splitedInput).toList();
    }
}
