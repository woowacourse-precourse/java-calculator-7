package calculator;

import java.util.HashSet;
import java.util.Set;
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

    private boolean isCustomPattern(String input){
        Matcher matcher = toMatcher(CUSTOM_PATTERN, input);
        return matcher.find() && (matcher.start() == 0);
    }

    private boolean isReservePattern(String input){
        Matcher matcher = toMatcher(RESERVE_PATTERN, input);

        Set<String> delimiters = new HashSet<>();
        while(matcher.find()){
            delimiters.add(matcher.group());
        }

        if (delimiters.contains(",") || delimiters.contains(":")){
            return true;
        }
        return false;
    }



}
