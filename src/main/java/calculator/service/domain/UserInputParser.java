package calculator.service.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputParser {
    private static final int DELIMITER_INDEX = 2;

    public static List<Character> parseCustomDelimiter(String userInput) {
        List<Character> result = extractChars(userInput);

        return result;
    }

    public static List<Double> parseNumber(String userInput, DelimiterHandler delimiterHandler) {
        String userInputAfterParse = getUserInputAfterParse(userInput);
        checkOnlyNumberAndDelimiter(userInputAfterParse, delimiterHandler);
        List<Double> result = extractNumbers(userInputAfterParse, delimiterHandler);

        return result;
    }

    private static void checkOnlyNumberAndDelimiter(String userInputAfterParse, DelimiterHandler delimiterHandler) {
        for (Character each : userInputAfterParse.toCharArray()) {
            if (!Character.isDigit(each) && !delimiterHandler.isValidDelimiter(each)) {
                throw new IllegalArgumentException("형식에 맞지 않는 문자열을 입력했습니다.");
            }
        }
    }

    private static List<Double> extractNumbers(String userInputAfterParse, DelimiterHandler delimiterHandler) {
        StringBuilder numberBuilder = new StringBuilder();
        List<Double> numberList = new ArrayList<>();

        for (Character each : userInputAfterParse.toCharArray()) {
            if (delimiterHandler.isValidDelimiter(each)) {
                if (numberBuilder.isEmpty()) {
                    continue;
                }
                numberList.add(Double.valueOf(numberBuilder.toString()));
                numberBuilder.delete(0, numberBuilder.length());
                continue;
            }
            numberBuilder.append(each);
        }

        if (!numberBuilder.isEmpty()) {
            numberList.add(Double.valueOf(numberBuilder.toString()));
        }
        return numberList;
    }

    private static String getUserInputAfterParse(String userInput) {
        String userInputAfterParse = removePatterns(userInput);

        return userInputAfterParse;
    }

    private static String removePatterns(String userInput) {
        Matcher matcher = createMatcher(userInput);

        return matcher.replaceAll("");
    }

    private static List<Character> extractChars(String userInput) {
        List<Character> result = new ArrayList<>();
        Matcher matcher = createMatcher(userInput);

        while (matcher.find()) {
            result.add(matcher.group().charAt(DELIMITER_INDEX));
        }

        return result;
    }

    private static Matcher createMatcher(String userInput) {
        Pattern pattern = Pattern.compile("//.\\\\n");

        return pattern.matcher(userInput);
    }

}
