package calculator.separator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddSeparator {

    private static final String regex = "//(.)\\\\n(.*)";
    private static SeparatorStorage separatorStorage = new SeparatorStorage();
    public static String addCustomSeparator(String userInput) {

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userInput);

        if (matcher.find()) {
            String delimiter = matcher.group(1);

            separatorStorage.addSeparator(delimiter);

            String remainingInput = matcher.group(2);
            return remainingInput;
        }

        if(userInput.matches("^[1-9].*"))
            return userInput;

        if(userInput.matches("^-.*"))
            throw new IllegalArgumentException("양수만 입력가능합니다");

        throw new IllegalArgumentException("올바른 형식으로 입력해주세요.");
    }
}
