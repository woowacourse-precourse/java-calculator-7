package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashSet;

public class NumbersParser {
    
    private static final Pattern areaDividePattern = Pattern.compile("^(?://([^0-9]*)\\\\n)?(.*)");
    private String separatorArea = null;
    private String numberArea = null;

    static final String defaultSeparators = ",:";
    private HashSet<Character> separatorSet = null;
    
    public NumbersParser(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        setAreaByPattern(input);
        separatorSet = parseSeparator(defaultSeparators + separatorArea);
    }
    
    private void setAreaByPattern(String input) {
        Matcher matchResult = areaDividePattern.matcher(input);
        if (!matchResult.matches()) {
            throw new IllegalArgumentException();
        }
        
        separatorArea = (matchResult.group(1) == null ? "" : matchResult.group(1)); 
        numberArea = (matchResult.group(2) == null ? "" : matchResult.group(2));
    }
    
    private HashSet<Character> parseSeparator(String separators) {
        separatorSet = new HashSet<Character>(separators.length());
        
        for (int i = 0; i < separators.length(); i++) {
            separatorSet.add(separators.charAt(i));
        }
        
        return separatorSet;
    }
}
