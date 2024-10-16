package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserString {
    private static final String REGEX_PATTERN = "^//(.)(\\\\n.*)";

    public static boolean checkCustomSeparator(String inputString){
        return Pattern.matches(REGEX_PATTERN,inputString);
    }

    public static String getCustomSeparator(String inputString){
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        Matcher matcher = pattern.matcher(inputString);
        String separator = "";
        if(matcher.matches()){
            separator =  matcher.group(1);
        }
        return separator;
    }
}