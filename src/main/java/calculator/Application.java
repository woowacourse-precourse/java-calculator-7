package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    private static final String INPUT_GUIDE_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_INPUT_REGEX = "^//(.*?)\\\\n(.*)";

    public static void main(String[] args) {

        String[] inputStringAndDelimiters = getInputString();
        String delim = inputStringAndDelimiters[0];
        String inputString = inputStringAndDelimiters[1];

        int[] extractedNumbers = extractNumbers(delim, inputString);
        System.out.println(Arrays.toString(extractedNumbers));
    }

    private static String[] getInputString() {

        String[] inputStringAndDelimiters = new String[2];

        System.out.println(INPUT_GUIDE_MESSAGE);
        String userInput = Console.readLine();

        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_INPUT_REGEX);
        Matcher matcher = pattern.matcher(userInput);

        if (matcher.matches()) {
            inputStringAndDelimiters[0] = makeDelimiterRegex(matcher.group(1));
            inputStringAndDelimiters[1] = matcher.group(2);

            return inputStringAndDelimiters;
        }

        inputStringAndDelimiters[0] = DEFAULT_DELIMITER_REGEX;
        inputStringAndDelimiters[1] = userInput;

        return inputStringAndDelimiters;
    }

    private static int[] extractNumbers(String delim, String inputString) {

        String[] extractedStringNumbers = inputString.split(delim);
        return Arrays.stream(extractedStringNumbers).mapToInt(Integer::parseInt).toArray();
    }

    private static String makeDelimiterRegex(String DelimString) {
        return "[" + DelimString + "]";
    }
}
