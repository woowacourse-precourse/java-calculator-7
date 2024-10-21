package calculator.separator;

import calculator.utility.NumberWrapper;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DefaultSeparator {

    public NumberWrapper[] separateStringToSum(String userInput, DelimiterStorage delimiterStorage) throws IllegalArgumentException{

        if (containsInvalidDelimiter(userInput, delimiterStorage)) {
            throw new IllegalArgumentException("유효한 구분자가 입력에 포함되지 않았습니다");
        }

        String [] parsedStrings = userInput.split(getRegex(delimiterStorage));

        if(Arrays.stream(parsedStrings)
                .anyMatch(String::isEmpty)){
            throw new IllegalArgumentException("문자열에 숫자가 포함되지 않은 부분이 있습니다");
        }

        NumberWrapper[] numbers = Arrays.stream(parsedStrings)
                .map(NumberWrapper::new)
                .toArray(NumberWrapper[]::new);

        return numbers;
    }

    private static boolean containsInvalidDelimiter(String input, DelimiterStorage delimiterStorage) {

        String allowedSeparators = delimiterStorage.getDelimiters()
                .stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));

        String regex = "^[\\d" + allowedSeparators + "]+$";

        return !Pattern.matches(regex, input);
    }

    private static String getRegex(DelimiterStorage delimiterStorage) {
        return delimiterStorage.getDelimiters()
                .stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }
}
