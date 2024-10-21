package calculator.separator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterAdder {

    private static final String regex = "//(.)\\\\n(.*)";
    private static DelimiterStorage delimiterStorage = new DelimiterStorage();
    public static String addCustomDelimiter(String userInput) {

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userInput);

        if (matcher.find()) {
            String delimiter = matcher.group(1);

            delimiterStorage.addDelimiter(delimiter);

            String remainingInput = matcher.group(2);
            return remainingInput;
        }

        if(userInput.matches("^[1-9].*"))
            return userInput;

        throw new IllegalArgumentException("올바른 형식으로 입력해주세요.");
    }
}
