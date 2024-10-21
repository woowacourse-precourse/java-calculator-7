package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final String DEFAULT_DELIMITER = "[,|:]";
    private static final String CUSTOM_DELIMITER_REGEX = "^//(.)\n(.*)$";


    public List<Integer> parseToInt(String input, PatternType patternType) {
        String[] parsedStrings = parseWithPattern(input, patternType);
        return convertStringsToNumbers(parsedStrings);
    }

    private String[] parseWithPattern(String input, PatternType patternType) {
        String expression = input;
        String delimiters = DEFAULT_DELIMITER;
        if (patternType == PatternType.CUSTOM) {
            Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
            if (matcher.find()) {
                delimiters = Pattern.quote(matcher.group(1));
                expression = matcher.group(2);
            }
        }
        return expression.split(delimiters);
    }

    private List<Integer> convertStringsToNumbers(String[] strings) {
        List<Integer> numbers = new ArrayList<>();
        for (String str : strings) {
            int num = Integer.parseInt(str);
            numbers.add(num);
        }
        return numbers;
    }
}
