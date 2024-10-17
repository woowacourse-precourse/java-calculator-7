package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashSet;

public class NumbersParser {
    
    private static final Pattern areaDividePattern = Pattern.compile("^(?://([^0-9]*)\\\\n)?(.*)");
    private String separatorArea = null;
    private String numberArea = null;

    static final char[] defaultSeparators = new char[] { ',', ':' };
    private HashSet<Character> separatorSet = null;
    
    public NumbersParser(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        setAreaByPattern(input);
        separatorSet = parseSeparator();
    }
    
    private void setAreaByPattern(String input) {
        Matcher matchResult = areaDividePattern.matcher(input);
        if (!matchResult.matches()) {
            throw new IllegalArgumentException();
        }
        
        separatorArea = (matchResult.group(1) == null ? "" : matchResult.group(1)); 
        numberArea = (matchResult.group(2) == null ? "" : matchResult.group(2));
    }
    
    private HashSet<Character> parseSeparator() {
        separatorSet = new HashSet<Character>(defaultSeparators.length + separatorArea.length());
        
        for (int i = 0; i < defaultSeparators.length; i++) {
            separatorSet.add(defaultSeparators[i]);
        }
        for (int i = 0; i < separatorArea.length(); i++) {
            separatorSet.add(separatorArea.charAt(i));
        }
        
        return separatorSet;
    }
}
