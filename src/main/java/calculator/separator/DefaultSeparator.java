package calculator.separator;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DefaultSeparator {

    public int[] separateStringToSum(String UserInput, SeparatorStorage separatorStorage){

        String [] parsedStrings = UserInput.split(getRegex(separatorStorage));

        int[] numbers = Arrays.stream(parsedStrings)
                .mapToInt(Integer::parseInt)
                .toArray();

        return numbers;
    }

    private static String getRegex(SeparatorStorage separatorStorage) {
        return separatorStorage.getSeparators()
                .stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }
}
