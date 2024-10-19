package calculator.separator;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DefaultSeparator {

    public BigInteger[] separateStringToSum(String userInput, SeparatorStorage separatorStorage){

        String [] parsedStrings = userInput.split(getRegex(separatorStorage));

        BigInteger[] numbers = Arrays.stream(parsedStrings)
                .map(BigInteger::new)
                .toArray(BigInteger[]::new);

        return numbers;
    }

    private static String getRegex(SeparatorStorage separatorStorage) {
        return separatorStorage.getSeparators()
                .stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }
}
