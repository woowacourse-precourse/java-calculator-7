package calculator.separator;

import calculator.NumberWrapper;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DefaultSeparator {

    public NumberWrapper[] separateStringToSum(String userInput, SeparatorStorage separatorStorage) throws IllegalArgumentException{

        if (containsInvalidSeparator(userInput, separatorStorage)) {
            throw new IllegalArgumentException("유효한 구분자가 입력에 포함되지 않았습니다");
        }

        String [] parsedStrings = userInput.split(getRegex(separatorStorage));

        if(Arrays.stream(parsedStrings)
                .anyMatch(String::isEmpty)){
            throw new IllegalArgumentException("문자열에 숫자가 포함되지 않은 부분이 있습니다");
        }

        NumberWrapper[] numbers = Arrays.stream(parsedStrings)
                .map(NumberWrapper::new)
                .toArray(NumberWrapper[]::new);

        return numbers;
    }

    private static boolean containsInvalidSeparator(String input, SeparatorStorage separatorStorage) {

        String allowedSeparators = separatorStorage.getSeparators()
                .stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));

        String regex = "^[\\d" + allowedSeparators + "]+$";

        return !Pattern.matches(regex, input);
    }

    private static String getRegex(SeparatorStorage separatorStorage) {
        return separatorStorage.getSeparators()
                .stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }
}
