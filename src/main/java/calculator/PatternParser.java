package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternParser {

    public static final String CUSTOM_PATTERN = "^//(.*?)\n";
    public static final String RESERVE_PATTERN = "[,:]";

    private Pattern toPattern(String regex){
        return Pattern.compile(regex);
    }

    private Matcher toMatcher(String regex, String input){
        return toPattern(regex).matcher(input);
    }

}
