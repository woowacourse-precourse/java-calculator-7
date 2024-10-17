package calculator.service;

import calculator.model.Numbers;
import calculator.model.UserInput;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    private static final String DEFAULT_REGEX = ",|:";

    public Numbers parse(UserInput input) {
        String regex = DEFAULT_REGEX;
        String numString = input.getInputString();
        Pattern pattern = Pattern.compile("//(.)\\\\n(.*)");
        Matcher matcher = pattern.matcher(numString);

        if (matcher.find()) {
            String customRegex = Pattern.quote(matcher.group(1));
            regex = regex + "|" + customRegex;
            numString = matcher.group(2);
        }

        String[] strParts = numString.split(regex);
        List<Integer> numbers = Arrays.stream(strParts)
                .map(Integer::parseInt)
                .toList();
        return new Numbers(numbers);
    }
}
