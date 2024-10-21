package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    private static final String REGEX = "//.*\\\\n";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(REGEX);

    public static boolean validate(String s){

        if(s.startsWith("/"))
            return doesStartWithCorrectFormat(s);

        return checkAllLettersAreLegal(s);
    }

    private static boolean doesStartWithCorrectFormat(String s){

        Matcher matchingResult = CUSTOM_DELIMITER_PATTERN.matcher(s);

        return matchingResult.find() && matchingResult.start() == 0;
    }

    private static boolean checkAllLettersAreLegal(String input) {
        for(int i = 0; i < input.length(); i++){

            if(isLegalLetter(input, i))
                continue;

            return false;

        }

        return true;
    }
    private static boolean isLegalLetter(String input, int i) {
        return Character.isDigit(input.charAt(i)) || input.charAt(i) == ',' || input.charAt(i) == ';';
    }
}
