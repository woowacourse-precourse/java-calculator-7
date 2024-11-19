package calculator.service.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {
    private static final int FIND_FIRST_CHAR = 0;

    public static List<Character> parseCustomDelimiter(String userInput) {
        List<Character> result = extractChars(userInput);

        return result;
    }

    public static String getUserInputAfterParse(String userInput) {
        String userInputAfterParse = removePatterns(userInput);

        return userInputAfterParse;
    }

    private static String removePatterns(String userInput) {
        StringBuilder afterParseBuilder = new StringBuilder();
        Matcher matcher = createMatcher(userInput);

        int patternLastIndex = 0;
        while (matcher.find()) {
            afterParseBuilder.append(userInput, patternLastIndex, matcher.start());
            patternLastIndex = matcher.end();
        }

        afterParseBuilder.append(userInput.substring(patternLastIndex));
        return afterParseBuilder.toString();
    }

    private static List<Character> extractChars(String userInput) {
        List<Character> result = new ArrayList<>();
        Matcher matcher = createMatcher(userInput);

        while (matcher.find()) {
            result.add(matcher.group().charAt(FIND_FIRST_CHAR));
        }

        return result;
    }

    private static Matcher createMatcher(String userInput) {
        Pattern pattern = Pattern.compile("(?<=//).(?=\\n)");
        return pattern.matcher(userInput);
    }

}
