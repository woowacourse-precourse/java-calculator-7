package calculator.model;

import java.util.regex.Pattern;

public class StringType {
    private static final Pattern defaultPattern = Pattern.compile("([1-9][0-9]*([,:][1-9][0-9]*)*)?");
    private static final Pattern customPattern = Pattern.compile("//(.)\\\\n([1-9][0-9]*(\\1[1-9][0-9]*)*)?");

    private boolean isDefaultPattern(String input){
        return defaultPattern.matcher(input).matches();
    }
    private boolean isCustomPattern(String input){
        return customPattern.matcher(input).matches();
    }

    public PatternType findPatternType(String input){
        if(isDefaultPattern(input))
            return PatternType.DEFAULT_PATTERN;
        if(isCustomPattern(input))
            return PatternType.CUSTOM_PATTERN;

        return PatternType.INVALID_PATTERN;
    }
}
