package calculator.Utils;

import calculator.Model.Delimiter;
import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    public static List<String> splitByDelimiter(String userInput, Delimiter delimiter) {
        String[] splitedInput = userInput.split(delimiter.getDelimiter());
        return Arrays.stream(splitedInput).toList();
    }
}
